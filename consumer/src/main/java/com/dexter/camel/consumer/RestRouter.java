package com.dexter.camel.consumer;

import com.dexter.camel.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRouter  extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/account").apiContextPath("/api-doc")
                .apiProperty("api.title", "Camel REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("account")
                .bindingMode(RestBindingMode.json);

        rest("/user")
                .produces("application/json")
                .consumes("application/json")
                .get("/").route().routeId("get-user-route")
                .outputType(User.class).outputType(String.class)
                .bean(GetUserProcessor.class);
    }
}

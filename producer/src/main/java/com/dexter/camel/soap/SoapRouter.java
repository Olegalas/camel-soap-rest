package com.dexter.camel.soap;

import com.dexter.camel.model.UserService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SoapRouter extends RouteBuilder{

    private String url = "cxf:user?serviceClass=" + UserService.class.getName();

    @Override
    public void configure() throws Exception {
        from(url).routeId("user-soap")
                .to("log:input")
                .recipientList(simple("direct:${header.operationName}"));

        from("direct:getUser")
                .bean(GetUserProcessor.class)
                .to("log:output");
    }
}

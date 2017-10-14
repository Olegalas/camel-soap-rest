package com.dexter.camel.soap;

import com.dexter.camel.model.GetUserRequest;
import com.dexter.camel.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserProcessor implements Processor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(Exchange exchange) throws Exception {
        GetUserRequest body = exchange.getIn().getBody(GetUserRequest.class);
        log.info("received body : {}", body);

        User user = new User();
        user.setPassword("some password");
        user.setLogin("Dexter");
        user.setAge(45);
        user.setState(User.State.NEW);
        exchange.getOut().setBody(user);
    }
}

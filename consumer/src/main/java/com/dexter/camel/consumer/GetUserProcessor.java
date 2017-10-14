package com.dexter.camel.consumer;

import com.dexter.camel.model.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class GetUserProcessor implements Processor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserManager userManager;

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpSession session = exchange.getIn(HttpMessage.class).getRequest().getSession();
        User user = userManager.getUser(session.getId());
        log.info("Was received user : {}", user);
        exchange.getOut().setBody(user);
    }
}

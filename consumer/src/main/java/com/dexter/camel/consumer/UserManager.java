package com.dexter.camel.consumer;

import com.dexter.camel.model.GetUserRequest;
import com.dexter.camel.model.User;
import com.dexter.camel.model.UserService;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserManager {

    @Value("${user.soap.address}")
    private String address;

    private UserService userService;

    @PostConstruct
    private void setUp(){
        ClientProxyFactoryBean factoryBean = new ClientProxyFactoryBean();
        factoryBean.setAddress(address);
        factoryBean.setServiceClass(UserService.class);
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        userService = factoryBean.create(UserService.class);
    }

    public User getUser(String sessionId) {
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setSessionId(sessionId);
        return userService.getUser(getUserRequest);
    }

}

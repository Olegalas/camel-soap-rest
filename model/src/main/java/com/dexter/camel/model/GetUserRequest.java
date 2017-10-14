package com.dexter.camel.model;

public class GetUserRequest {

    private String sessionId;


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GetUserRequest{");
        sb.append("sessionId='").append(sessionId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.dexter.camel.model;

public class User {

    private String login;
    private String password;
    private int age;
    private State state;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", age=").append(age);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }

    public enum State {
        NEW,
        BUNNED,
        ACTIVE
    }

}

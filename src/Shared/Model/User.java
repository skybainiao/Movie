package Shared.Model;

import Client.Model.Login.LoginState;

import java.io.Serializable;

public class User implements Serializable {

    private LoginState state;
    private String username;
    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    public void login() throws Exception {
        state.login();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

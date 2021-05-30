package Shared.Model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String username,String password){
        this.username=username;
        this.password=password;
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

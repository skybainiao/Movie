package Shared.Model;

import java.io.Serializable;

public class Review implements Serializable{
    private String reviewUsername;
    private String text;

    public Review(String reviewUsername,String text){
        this.reviewUsername=reviewUsername;
        this.text=text;
    }

    public void setUsername(String username) {
        this.reviewUsername=username;
    }

    public String getUsername() {
        return reviewUsername;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return reviewUsername+"  : "+text;
    }
}

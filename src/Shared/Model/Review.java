package Shared.Model;

import java.io.Serializable;

public class Review implements Serializable {
    private int star;
    private String text;

    public Review(String username,int star,String review){
        this.text=review;
        this.star=star;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getStar() {
        return star;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Review{" +
                "star=" + star +
                ", review='" + text + '\'' +
                '}';
    }
}

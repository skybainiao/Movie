package Shared;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private int id;
    private String productionYear;
    private String productionCompany;
    private String averageReview;
    private String status;

    public Movie(int id,String title,String productionYear,String productionCompany,String averageReview,String status){
        this.title=title;
        this.id=id;
        this.productionYear=productionYear;
        this.productionCompany=productionCompany;
        this.averageReview=averageReview;
        this.status=status;
    }

    public void setAverageReview(String averageReview) {
        this.averageReview = averageReview;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAverageReview() {
        return averageReview;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public String getStatus() {
        return status;
    }

    public void increase(){
        id++;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", productionYear=" + productionYear +
                ", productionCompany='" + productionCompany + '\'' +
                ", averageReview=" + averageReview +
                ", status='" + status + '\'' +
                '}';
    }
}
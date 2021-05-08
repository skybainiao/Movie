package Server;

import Shared.Model.Review;
import Shared.Model.User;
import Shared.Movie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImpl implements Server{
    private Movie movie;
    private Review review;
    private ArrayList<User> users;
    private ArrayList<Movie> movieList;
    private ArrayList<Review> reviewList;
    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,6666);
        movieList=new ArrayList<>();
        reviewList=new ArrayList<>();
        users=new ArrayList<>();
        review=new Review("",0,"");
        movie=new Movie(0,"","","","","");
    }

    @Override
    public void addUser(User user) throws RemoteException {
        users.add(user);
    }

    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        return users;
    }

    @Override
    public void addMovie(Movie movie) throws RemoteException {
        movieList.add(movie);
    }

    @Override
    public void removeMovie(Movie movie) throws RemoteException {
       for (int i =0;i<movieList.size();i++)
       {
           if (movieList.get(i).getId()== movie.getId())
           {
               movieList.remove(i);
               break;
           }
       }
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        return movieList;
    }

    @Override
    public void addReview(Review review) throws RemoteException {
        reviewList.add(review);
    }

    @Override
    public void removeReview(Review review) throws RemoteException {
        reviewList.remove(review);
    }

    @Override
    public ArrayList<Review> getReviews() throws RemoteException {
        return reviewList;
    }

    @Override
    public void setAverageReview(String averageReview) throws RemoteException {
        movie.setAverageReview(averageReview);
    }

    @Override
    public void setProductionCompany(String productionCompany) throws RemoteException{
        movie.setProductionCompany(productionCompany);
    }

    @Override
    public void setProductionYear(String productionYear) throws RemoteException {
        movie.setProductionYear(productionYear);
    }

    @Override
    public void setStatus(String status) throws RemoteException {
        movie.setStatus(status);
    }

    @Override
    public void setTitle(String title) throws RemoteException {
        movie.setTitle(title);
    }

    @Override
    public int getId() throws RemoteException {
        return movie.getId();
    }

    @Override
    public String getTitle() throws RemoteException {
        return movie.getTitle();
    }

    @Override
    public String getAverageReview() throws RemoteException {
        return movie.getAverageReview();
    }

    @Override
    public String getProductionYear() throws RemoteException {
        return movie.getProductionYear();
    }

    @Override
    public String getProductionCompany() throws RemoteException {
        return movie.getProductionCompany();
    }

    @Override
    public String getStatus() throws RemoteException {
        return movie.getStatus();
    }

    @Override
    public void increase() throws RemoteException {
        movie.increase();
    }

    @Override
    public void setText(String text) throws RemoteException {
        review.setText(text);
    }

    @Override
    public void setStar(int star) throws RemoteException {
        review.setStar(star);
    }

    @Override
    public int getStar() throws RemoteException {
        return review.getStar();
    }

    @Override
    public String getText() throws RemoteException {
        return review.getText();
    }


}

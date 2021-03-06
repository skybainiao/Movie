package Server;

import Client.Networking.Client;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;
import Shared.Util.JDBC;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerImpl implements Server{

    private Movie movie;
    private JDBC jdbc;
    private ArrayList<Client> clients;
    private PropertyChangeSupport support;
    private Status status;

    public ServerImpl() throws Exception {
        Registry registry= LocateRegistry.createRegistry(6666);
        registry.bind("Server",this);
        UnicastRemoteObject.exportObject(this,6666);

        System.out.println("Server Start");

        clients=new ArrayList<>();
        support=new PropertyChangeSupport(this);
        this.jdbc=new JDBC();
        movie=new Movie("",0,"","","","","",0,0);
        this.status=new Status(this);
        status.run();
    }


    @Override
    public void addClient(Client client){
        clients.add(client);
        support.firePropertyChange("client",null,client);
    }


    @Override
    public void addUser(User user) throws RemoteException {
        try {
            jdbc.addUser(user);
            support.firePropertyChange("user",user,user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<User> getUsers() throws RemoteException, SQLException {
        ResultSet rs = jdbc.getAllUsers();
        ArrayList<User> userList =new ArrayList<>();

        try{
            while(rs.next()){
                userList.add(new User(rs.getString("username"),rs.getString("password")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return userList;
    }


    @Override
    public ArrayList<Movie> getSearchMovies(String searchText) throws SQLException, RemoteException {
        ResultSet rs = jdbc.getSearchMovies(searchText);
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");
                int likeNum=rs.getInt("likeNum");
                int dislikeNum=rs.getInt("dislikeNum");

                Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,likeNum,dislikeNum);
                movies.add(movie);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return movies;
    }


    @Override
    public void likeIncrease(Movie movie) throws SQLException ,RemoteException{
        try {
            jdbc.updateLike(movie.getTitle());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void dislikeIncrease(Movie movie) throws RemoteException, SQLException {
        try {
            jdbc.updateDislike(movie.getTitle());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public Movie getMovie(Movie movie) throws SQLException ,RemoteException{
        ResultSet rs = jdbc.getMovie(movie.getTitle());
        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");
                int likeNum=rs.getInt("likeNum");
                int dislikeNum=rs.getInt("dislikeNum");
                Movie movie1=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,likeNum,dislikeNum);

                return movie1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void addMovie(Movie movie) throws RemoteException {
        try {
            jdbc.addMovie(movie);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void removeMovie(int movieID) throws RemoteException, SQLException {
        try {
            jdbc.removeMovie(movieID);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Movie> getMovies() throws RemoteException, SQLException {
        ResultSet rs = jdbc.getAllMovies();
        ArrayList<Movie> allMovies = new ArrayList<>();

        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");
                int likeNum=rs.getInt("likeNum");
                int dislikeNum=rs.getInt("dislikeNum");

                Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,likeNum,dislikeNum);
                allMovies.add(movie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allMovies;
    }


    @Override
    public void addLikeMovie(String username,String movieName) throws SQLException,RemoteException {
        try {
            jdbc.addLikeMovie(username,movieName);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Movie> getLikedMovies(String username) throws RemoteException, SQLException {
        ResultSet rs = jdbc.getLikedMovies(username);
        ArrayList<Movie> likedMovies = new ArrayList<>();

        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");
                int likeNum=rs.getInt("likeNum");
                int dislikeNum=rs.getInt("dislikeNum");

                Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,likeNum,dislikeNum);
                likedMovies.add(movie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return likedMovies;
    }


    @Override
    public void addReview(Review review,String title) throws RemoteException, SQLException {
        try {
            jdbc.addReview(review,title);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException {
        ResultSet rs = jdbc.getReviews(movie.getTitle());
        ArrayList<Review> reviews = new ArrayList<>();

        try {
            while (rs.next()){
                String username=rs.getString("username");
                String text=rs.getString("text");

                Review review=new Review(username,text);
                reviews.add(review);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return reviews;
    }


    @Override
    public int getId() throws RemoteException {
        return movie.getId();
    }


    @Override
    public void increase() throws RemoteException {
        movie.increase();
    }


    @Override
    public void addWatchLater(String username,Movie movie) throws SQLException {
        try {
            jdbc.addWatchLaterMovie(username,movie.getTitle());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Movie> getWatchLater(String username) throws SQLException {
        ResultSet rs=jdbc.getWatchLaterMovies(username);
        ArrayList<Movie> movies=new ArrayList<>();

        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");
                int likeNum=rs.getInt("likeNum");
                int dislikeNum=rs.getInt("dislikeNum");

                Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,likeNum,dislikeNum);
                movies.add(movie);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return movies;
    }


    @Override
    public void addUrl(String url,String username) throws SQLException ,RemoteException{
        try {
            jdbc.addUrl(url,username);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String getUrlOfUser(String username) throws SQLException ,RemoteException{
        ResultSet rs = jdbc.getImageOfUser(username);
        String url = "";

        while (rs.next()){
             url = rs.getString("movieImagePath");
        }

        return url;
    }


    @Override
    public void addPCL(String name, PropertyChangeListener listener) throws RemoteException {
        support.addPropertyChangeListener(name,listener);
    }

    @Override
    public void removePCL(String name, PropertyChangeListener listener) throws RemoteException {
        support.removePropertyChangeListener(name,listener);
    }
}

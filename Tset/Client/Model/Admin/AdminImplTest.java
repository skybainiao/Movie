package Client.Model.Admin;

import Client.Networking.Client;
import Client.Networking.ClientImpl;
import Server.Server;
import Server.ServerImpl;
import Shared.Model.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AdminImplTest {
    private Server server;
    private Client client;

    @Test
    void addMovie() throws Exception {
        Movie movie =new Movie("",0,"","","","","",1,1);
        server=new ServerImpl();
        client=new ClientImpl("chen");
        client.addMovie(movie);
        assertNotNull(client.getMovies());


    }

    @Test
    void removeMovie() {
    }

    @Test
    void getMovies() {
    }

    @Test
    void increase() {
    }

    @Test
    void getId() {
    }
}
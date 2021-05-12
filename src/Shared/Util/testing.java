package Shared.Util;

import Shared.Model.Movie;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testing {
    private getData getData;
    public static void main(String[] args) throws Exception {

        DBUtil dbUtil = new DBUtil();
        dbUtil.getConnection();



    }

}

class test{
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Nice","Message",JOptionPane.INFORMATION_MESSAGE);
    }
}

class testTime{
    public static void main(String[] args) {
        DateFormat dateFormat=new SimpleDateFormat();
        Date date=new Date();
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.getTimeZone());
    }
}

class getData{
    public Movie getAllMovies(Connection con, String movie) throws Exception{
        String sql="select * from movie";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, movie);
        return pstmt.executeQuery();
    }
}

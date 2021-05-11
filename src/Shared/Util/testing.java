package Shared.Util;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testing {


    public static void main(String[] args) throws Exception {
        DBUtil dbUtil = new DBUtil();
        dbUtil.getCon();
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

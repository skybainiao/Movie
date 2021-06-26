package Shared.Model;

public class SystemLog {
    private static SystemLog instance = new SystemLog();

    private SystemLog(){ }

    public static SystemLog getInstance(){
        if (instance == null){
            instance=new SystemLog();
        }
        return instance;
    }

    public void SystemLog(String log){
        System.out.println(log);
    }


}

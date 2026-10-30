package Singleton;

public class AppConfig{
    private static AppConfig appConfig;
    private String appName;
    private int serverPort;
    private boolean testMode;

    private AppConfig(){
        this.appName = "MyApp";
        this.serverPort = 1337;
        this.testMode = false;
    }

    public static synchronized AppConfig getAppConfig(){
        if (appConfig == null){
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public boolean testMode(){
        return testMode;
    }

    public void setTestMode(boolean testMode){
        this.testMode = testMode;
    }
}

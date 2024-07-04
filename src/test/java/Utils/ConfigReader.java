package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop ;
    public ConfigReader(){

    }

    public Properties ConfigurationManager() {
        this.prop = new Properties();
        File proFile = new File("src/test/resources/configs/configFile.properties");

        try {
            FileInputStream fis = new FileInputStream(proFile);
            this.prop.load(fis);
        } catch (Throwable var3) {
            var3.printStackTrace();
        }
        return this.prop;
    }

    public String getbrowsername(){
        String browsername = this.prop.getProperty("browsername");
        return browsername;
    }

    public String geturl(){
        String url = this.prop.getProperty("url");
        return url;
    }

    public String getusernname(){
        String username = this.prop.getProperty("username");
        return username;
    }

    public String getpassword(){
        String password = this.prop.getProperty("password");
        return password;
    }


}




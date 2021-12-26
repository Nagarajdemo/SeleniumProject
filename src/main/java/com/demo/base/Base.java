package com.demo.base;

import com.demo.utils.TestUtils;
import com.demo.utils.WebEventListner;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
   private static Properties prop;
    public static File file;
    public static WebEventListner eventListener;
    public  static EventFiringWebDriver e_driver;




    public Base() {
         file = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\demo\\config\\config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void initialize(){
        ChromeOptions opt = new ChromeOptions();
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY,opt);
        String browserName=prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\src\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        e_driver=new EventFiringWebDriver(driver);
        eventListener=new WebEventListner();
        e_driver.register(eventListener);
        driver=e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));


    }
}

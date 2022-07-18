package setupTeste;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class ConfiguracoesDoTeste {

    protected AndroidDriver<MobileElement> driver;

    
    Dotenv dotEnv = Dotenv.configure().load();
    private String USER_NAME = dotEnv.get("USER_NAME");
    private String USER_PSW = dotEnv.get("USER_PSW");
    private String BS_HASH_APP = dotEnv.get("LINK_APP");

    @BeforeTest    
    public void setup(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("device", "Samsung Galaxy S8 Plus");
        desiredCapabilities.setCapability("os_version", "7.0");        
        desiredCapabilities.setCapability("app", BS_HASH_APP);
        desiredCapabilities.setCapability("browserstack.idleTimeout", "15");

        try {
            driver = new AndroidDriver<MobileElement>(new URL("https://"+ USER_NAME +":" + USER_PSW + "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);        
    }

    @AfterTest(alwaysRun = true)
    public void killDriver(){
        driver.quit();
    }
    
}

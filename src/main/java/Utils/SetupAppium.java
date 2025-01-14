package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SetupAppium {

    public static AndroidDriver driver;


    public static WebElement findElement(By element) {
        return driver.findElement(element);
    }
    public static List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    public void androidDriverSetUp() {
        try {
            UiAutomator2Options caps = new UiAutomator2Options();

            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UIAutomator2");
            caps.setCapability("deviceName", "Poco");
            caps.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/quora.apk");
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("appPackage", "com.quora.android");
            caps.setCapability("appActivity", ".components.activities.LauncherActivity");
            caps.setCapability("noReset", false);
            caps.setCapability("appWaitActivity", "*");
            caps.setCapability("uiautomator2ServerInstallTimeout", 60000);
            caps.setCapability("adbExecTimeout", 20000);
            caps.setCapability("newCommandTimeout", 300);
            URL appiumServer = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(appiumServer, caps);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}

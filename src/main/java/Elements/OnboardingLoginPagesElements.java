package Elements;


import org.openqa.selenium.By;

public class OnboardingLoginPagesElements {
    public static By login = By.xpath("//android.widget.Button[@text=\"Login\"]");
    public static By userEmail = By.xpath("//android.webkit.WebView[@text=\"Login\"]/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText");
    public static By userPass = By.xpath("//android.webkit.WebView[@text=\"Login\"]/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText");
    public static By log_in = By.xpath("//android.widget.Button[@text=\"Log in\"]");
}

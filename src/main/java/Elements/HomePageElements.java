package Elements;

import org.openqa.selenium.By;

public class HomePageElements {
    public static By profile = By.id("com.quora.android:id/navBarProfileImage");
    public static By home = By.id("com.quora.android:id/titleView");
    public static By profilePopup = By.xpath("(//android.widget.Button[@text=\"More\"])[1]");
    public static By logOut = By.xpath("//android.widget.TextView[@resource-id=\"com.quora.android:id/popover_menu_item_title\" and @text=\"Logout\"]");
    public static By consentExit = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
}

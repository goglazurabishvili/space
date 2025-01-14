package Elements;

import org.openqa.selenium.By;

public class SearchPageElements {
    public static By searchbar = By.id("com.quora.android:id/search_button_icon");
    public static By searchField = By.xpath("//android.widget.EditText");
    public static By collectTopics = By.xpath("//android.view.View[@content-desc]/android.view.View/android.view.View");
    public static By filter = By.xpath("//android.view.View[@text=\"View filters\"]");
}

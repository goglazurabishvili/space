package Elements;

import org.openqa.selenium.By;

public class MainPageElements {

    public static By tpostAuthor = By.xpath("//android.widget.TextView[@text]");
    public static By moreAction = By.xpath("//android.widget.Button[@text=\"More\"]");
    public static By deleteBookmark = By.xpath("//android.widget.TextView[@resource-id=\"com.quora.android:id/popover_menu_item_title\" and @text=\"Remove bookmark\"]");
    public static By bookmark = By.xpath("//android.widget.TextView[@resource-id=\"com.quora.android:id/popover_menu_item_title\" and @text=\"Bookmark\"]");
    public static By backButton = By.xpath("//android.widget.ImageView[@content-desc=\"Back\"]");
    public static By noBookMark = By.xpath("//android.widget.TextView[@text=\"No Bookmarks\"]");
    public static By getAuthorElement(String authorName) {
        return By.xpath("//android.widget.TextView[@text='" + authorName + "']");
    }
}

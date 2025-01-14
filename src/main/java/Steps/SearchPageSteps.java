package Steps;

import Elements.SearchPageElements;
import Utils.SetupAppium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static Utils.SetupAppium.findElement;

public class SearchPageSteps extends SearchPageElements {
//    private static AndroidDriver driver;
    private final AndroidDriver driver;

    public SearchPageSteps(AndroidDriver driver) {
        this.driver = driver != null ? driver : SetupAppium.driver;
    }

    public void printTopAuthor() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> entries = driver.findElements(collectTopics);
        System.out.println("Number of entries found: " + entries.size());

        String topAuthor = "";
        int maxFollowers = 0;

        for (WebElement entry : entries) {
            List<WebElement> childElements = entry.findElements(By.xpath(".//*"));

            String authorName = "";
            int followersCount = 0;

            for (WebElement child : childElements) {
                String text = child.getText();
                if (text.startsWith("Follow")) {
                    followersCount = extractFollowersCount(text);
                } else if (!text.isEmpty() && !text.startsWith("Icon for")) {
                    authorName = text;
                }
            }

            if (followersCount > maxFollowers) {
                maxFollowers = followersCount;
                topAuthor = authorName;
            }
        }

        System.out.println("Top author with the most followers: " + topAuthor + " (" + maxFollowers + " followers)");
    }

    private int extractFollowersCount(String followersText) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(followersText);
        if (matcher.find()) {
            String numberStr = matcher.group();
            if (followersText.endsWith("M")) {
                return (int) (Double.parseDouble(numberStr) * 1_000_000);
            } else if (followersText.endsWith("K")) {
                return (int) (Double.parseDouble(numberStr) * 1_000);
            } else {
                return Integer.parseInt(numberStr);
            }
        }
        return 0;
    }


    public SearchPageSteps clickOnSearchBar() {
        findElement(searchbar).click();
        return this;
    }

    public SearchPageSteps clickOnFilter() throws InterruptedException {
        Thread.sleep(2000);
        findElement(filter).click();
        return this;
    }
    public SearchPageSteps fillSearchField(String text) {
        findElement(searchField).sendKeys(text);
        return this;
    }



    public void tapOnCoordinates(int x, int y) throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            Dimension size = driver.manage().window().getSize();
            int screenWidth = size.getWidth();
            int screenHeight = size.getHeight();

            int calculatedX = (x * screenWidth) / 1080;
            int calculatedY = (y * screenHeight) / 2400;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 1);

            sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), calculatedX, calculatedY));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(java.util.List.of(sequence));
        } else {
            System.out.println("Driver is not initialized.");
        }
    }



}
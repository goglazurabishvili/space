package Steps;

import Elements.MainPageElements;

import static Utils.SetupAppium.*;

public class MainPageSteps extends MainPageElements {

    public String getFirstPostAuthor() throws InterruptedException {
        Thread.sleep(2000);
        return findElements(tpostAuthor).get(7).getText();
    }

    public MainPageSteps clickOnMoreActionUnderPost(){
        findElement(moreAction).click();
        return this;
    }
    public MainPageSteps addToBookMark(){
        findElement(bookmark).click();
        return this;
    }
    public MainPageSteps deleteBookMark(){
        findElement(deleteBookmark).isDisplayed();
        findElement(deleteBookmark).click();
        return this;
    }



    public MainPageSteps checkAuthor(String author) {
        boolean isAuthorDisplayed = findElement(getAuthorElement(author)).isDisplayed();
        if (isAuthorDisplayed) {
            System.out.println("Author " + author + " is displayed.");
        } else {
            System.out.println("Author " + author + " is not displayed.");
        }
        return this;
    }

    public void clickOnBackBTN(){
        findElement(backButton).click();
    }
    public boolean assertDeletedAuthor(){
        return findElement(noBookMark).isDisplayed();
    }


}

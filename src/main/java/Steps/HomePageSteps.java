package Steps;
import static Utils.SetupAppium.findElement;
import Elements.HomePageElements;

public class HomePageSteps extends HomePageElements {

    public HomePageSteps clickOnMyProfile(){
        findElement(profile).isDisplayed();
        findElement(profile).click();
        return this;
    }

    public boolean HomePageIsVisible(){
        return findElement(home).isDisplayed();
    }

    public HomePageSteps clickOnProfilePopUp(){
        findElement(profilePopup).click();
        return this;
    }
    public HomePageSteps clickOnLogOut(){
        findElement(logOut).click();
        return this;
    }
    public HomePageSteps consentToExit(){
        findElement(consentExit).click();
        return this;
    }
}

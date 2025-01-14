package Steps;

import Elements.OnboardingLoginPagesElements;

import static Utils.SetupAppium.findElement;
public class OnboardingLoginPagesSteps extends OnboardingLoginPagesElements {


    public OnboardingLoginPagesSteps clickOnLogIn(){
        findElement(login).click();
        return this;
    }

    public boolean forAssertLogOut(){
        return findElement(login).isDisplayed();
    }
    public OnboardingLoginPagesSteps fillUserEmail(String email){
        findElement(userEmail).sendKeys(email);
        return this;
    }

    public OnboardingLoginPagesSteps fillUserPass(String pass){
        findElement(userPass).sendKeys(pass);
        return this;
    }

    public OnboardingLoginPagesSteps continueToLogIn()  {
        findElement(log_in).click();
        return this;
    }


}

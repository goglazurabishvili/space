package UITest;

import Steps.HomePageSteps;
import Steps.MainPageSteps;
import Steps.OnboardingLoginPagesSteps;
import Steps.SearchPageSteps;
import Utils.SetupAppium;
import data.DataClass;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class QuoraUITests extends SetupAppium {
    @BeforeMethod
    public void setUp() {
        androidDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    OnboardingLoginPagesSteps login = new OnboardingLoginPagesSteps();
    MainPageSteps main = new MainPageSteps();
    HomePageSteps home = new HomePageSteps();
    SearchPageSteps search ;
    DataClass data = new DataClass();

    @Test(priority = 1)
    public void loginLogOutTest(){
        login.clickOnLogIn()
                .fillUserEmail(data.username)
                .fillUserPass(data.password)
                .continueToLogIn();
        Assert.assertTrue(home.HomePageIsVisible(),"Home icon should be displayed after login");

        home.clickOnMyProfile()
                .clickOnProfilePopUp()
                .clickOnLogOut()
                .consentToExit();
        Assert.assertTrue(login.forAssertLogOut(),"Login button should be displayed after logout");

    }

    @Test(priority = 2)
    public void searchAndPrintMostPopular() throws InterruptedException {
        login.clickOnLogIn()
                .fillUserEmail(data.username)
                .fillUserPass(data.password)
                .continueToLogIn();
        search = new SearchPageSteps(driver);
        search.clickOnSearchBar()
                .fillSearchField("Machine Learning\\n");
        search.clickOnFilter()
                .tapOnCoordinates(150,1000);
        search.tapOnCoordinates(966,167);
        search.printTopAuthor();
    }


    @Test(priority = 3)
    public void addToBookMarkAndDelete() throws InterruptedException {
        login.clickOnLogIn()
                .fillUserEmail(data.username)
                .fillUserPass(data.password)
                .continueToLogIn();
        search = new SearchPageSteps(driver);
        Thread.sleep(5000); //ვერ ასწრებს ჩატვირთვას,აპლიკაცია მთლად სწორად არ მუშაობს, სხვა მეთოდი უნდა ცხადია .
        String authorName =  main.getFirstPostAuthor();
        System.out.println(authorName);
        main.clickOnMoreActionUnderPost()
                .addToBookMark();
        home.clickOnMyProfile();
        search.tapOnCoordinates(200,827);
        main.checkAuthor(authorName)
            .clickOnMoreActionUnderPost()
            .deleteBookMark()
            .clickOnBackBTN();
        home.clickOnMyProfile();
        search.tapOnCoordinates(200,827);
        Thread.sleep(2000);
        Assert.assertTrue(main.assertDeletedAuthor());

    }
}

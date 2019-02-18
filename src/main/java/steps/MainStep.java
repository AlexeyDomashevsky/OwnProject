package steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ChooseNumberOfRoomsAndGuestsPage;
import pages.HotelsPage;
import pages.MainPage;

public class MainStep extends BaseStep {
//    TODO delete field. Move fields to method
    private BasePage basePage;
    private MainPage mainPage;
    private HotelsPage hotelsPage;

    public MainStep(WebDriver driver) {
        super(driver);
    }

    public  void changeLanguage(){
        basePage = new BasePage(driver);
        stepLogger.info("BasePage initialized with - driver"+driver.toString());
        basePage.clickLanguageButton();
        stepLogger.info("clickLanguageButton()");
        basePage.changeLanguage();
        stepLogger.info("changeLanguage()");
    }

    public String getSelectedLanguage(){
        return basePage.getUsedLanguage();
    }

    public void fillFieldsToFindOutHotels(){
        mainPage = new MainPage(driver);
        mainPage.fillFieldDestination();
        mainPage.fillFieldRequiredDate();
        ChooseNumberOfRoomsAndGuestsPage numberOfRoomsAndGuestsPage = mainPage.clickOnGuestInputField();
        numberOfRoomsAndGuestsPage.inputRequiredValue();
    }

    public void clickSearchButton(){
        hotelsPage = mainPage.clickSearchButton();
    }

    public long getCountOfRequiredHoitels(){
        return hotelsPage.findRequiredReviewScore();
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NumberOfGuestsPage extends BasePage {

    @FindBy(xpath = "//select[@id='no_rooms']")
    private WebElement roomsNumber;
    @FindBy(xpath = "//select[@id='group_adults']")
    private WebElement adultGuestNumber;

    public NumberOfGuestsPage(WebDriver webDriver) {
        super(webDriver);
    }

//    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-rooms']//span[@class='bui-stepper__display']")
//    private WebElement roomsNumberExist;


//    public MainPage fillFormNumberOfGuest(String adultsNumber,String roomsNumber){
//        this.roomsNumber.click();
//        this.roomsNumber.sendKeys(roomsNumber);
//        this.adultGuestNumber.click();
//        this.adultGuestNumber.sendKeys(adultsNumber);
////        roomsNumberExist.sendKeys(roomsNumber);//.getText()
//        return PageFactory.initElements(webDriver,MainPage.class);
//    }

    public MainPage fillFormNumberOfGuest(String adultsNumber, String roomsNumber) {
        fillNumberOfRoom(roomsNumber);
        fillNumberOfGuest(adultsNumber);
//        roomsNumberExist.sendKeys(roomsNumber);//.getText()
        return PageFactory.initElements(webDriver, MainPage.class);
    }

    public MainPage fillNumberOfRoom(String roomsNumber) {
        this.roomsNumber.click();
        this.roomsNumber.sendKeys(roomsNumber);

//        roomsNumberExist.sendKeys(roomsNumber);//.getText()
        return PageFactory.initElements(webDriver, MainPage.class);
    }

    public MainPage fillNumberOfGuest(String adultsNumber) {

        this.adultGuestNumber.click();
        this.adultGuestNumber.sendKeys(adultsNumber);
//        roomsNumberExist.sendKeys(roomsNumber);//.getText()
        return PageFactory.initElements(webDriver, MainPage.class);
    }
}

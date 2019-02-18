package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import services.PropertyReader;

public class ChooseNumberOfRoomsAndGuestsPage extends BasePage{

    private static final String NUMBER_OF_ROOMS = "number.of.rooms";
    private static final String NUMBER_OF_ADULTS = "number.of.adults";
    private static final String NUMBER_OF_CHILDREN = "number.of.children";
    private static final String ROOM_FIELD_XPATH = "//div[@class='sb-group__field sb-group__field-rooms']";
    private static final String ADULT_FIELD_XPATH = "//div[@class='sb-group__field sb-group__field-adults']";
    private static final String CHILDREN_FIELD_XPATH = "//div[@class='sb-group__field sb-group-children ']";
    private static final String NUMBER_XPATH =  "//span[@class='bui-stepper__display']";
    private static final String PLUS_BUTTON_XPATH = "//button[@class='bui-button bui-button--secondary bui-stepper__add-button']";
    private static final String MINUS_BUTTON_XPATH = "//button[@class='bui-button bui-button--secondary bui-stepper__subtract-button']";

    ChooseNumberOfRoomsAndGuestsPage(WebDriver driver) {
        super(driver);
    }

//TODO remove refactor
    public void inputRequiredValue(){
        setRequiredNumbersOfRoom(calculate(NUMBER_OF_ROOMS,ROOM_FIELD_XPATH+NUMBER_XPATH));
        pageLogger.info("setRequiredNumbersOfRoom(calculate(NUMBER_OF_ROOMS,ROOM_FIELD_XPATH+NUMBER_XPATH));");
        waiters.sleep(2000);
        setRequiredNumbersOfAdults(calculate(NUMBER_OF_ADULTS,ADULT_FIELD_XPATH+NUMBER_XPATH));
        pageLogger.info("setRequiredNumbersOfAdults(calculate(NUMBER_OF_ADULTS,ADULT_FIELD_XPATH+NUMBER_XPATH));");
        waiters.sleep(2000);
        setRequiredNumbersOfChildren(calculate(NUMBER_OF_CHILDREN,CHILDREN_FIELD_XPATH+NUMBER_XPATH));
        pageLogger.info("setRequiredNumbersOfChildren(calculate(NUMBER_OF_CHILDREN,CHILDREN_FIELD_XPATH+NUMBER_XPATH));");
        waiters.sleep(2000);
    }

    private int calculate(String requiredValue, String xpath){
        int count = parseStringToInteger(PropertyReader.getProperty(requiredValue))-
                    parseStringToInteger(getText(xpath));
        pageLogger.info("calculate = " + requiredValue +" "+ count);
        return count;
    }

    private void setRequiredNumbersOfRoom(int count){
        if(count>0){
            pageLogger.info("setRequiredNumbersOfRoom count<0");
            clickRepeatedly(count,ROOM_FIELD_XPATH+PLUS_BUTTON_XPATH);
        }if(count<0){
            clickRepeatedly(count,ROOM_FIELD_XPATH+MINUS_BUTTON_XPATH);
            pageLogger.info("setRequiredNumbersOfRoom count>0");
        }
    }
//    TODO pass in method first part of xpath
    private void setRequiredNumbersOfAdults(int count){
        if(count>0){
            clickRepeatedly(count,ADULT_FIELD_XPATH+PLUS_BUTTON_XPATH);
        }if(count<0){
            clickRepeatedly(count,ADULT_FIELD_XPATH+MINUS_BUTTON_XPATH);
        }
    }
    private void setRequiredNumbersOfChildren(int count){
        if(count>0){
            clickRepeatedly(count,CHILDREN_FIELD_XPATH+PLUS_BUTTON_XPATH);
        }if(count<0){
            clickRepeatedly(count,CHILDREN_FIELD_XPATH+MINUS_BUTTON_XPATH);
        }
    }

    public void ifa(int count, String row){
        WebElement element;
        if(count>0){
            element = driver.findElement(By.xpath(row+PLUS_BUTTON_XPATH));
        }else {
            element = driver.findElement(By.xpath(row+MINUS_BUTTON_XPATH));
        }
        for (int i = 0; i < count; i++) {
            element.click();
        }
    }

    private void clickRepeatedly(int count, String xpath){
        while (count!=0){
            if(count>0){
                clickPlusButton(xpath);
                --count;}
            if(count<0){
                clickMinusButton(xpath);
                ++count;
            }
        }
    }

    private void clickMinusButton(String xpath){
        waiters.sleep(1000);
        driver.findElement(By.xpath(xpath)).click();
        pageLogger.info("clickMinusButton");
    }

    private void clickPlusButton(String xpath){
        waiters.sleep(1000);
        driver.findElement(By.xpath(xpath)).click();
        pageLogger.info("clickPlusButton");
    }

    private Integer parseStringToInteger(String str){
        return Integer.valueOf(str);
    }

    private String getText(String xpath){
        String text = driver.findElement(By.xpath(xpath)).getText();
        pageLogger.info("getText = " +text);
        return text;
    }
}

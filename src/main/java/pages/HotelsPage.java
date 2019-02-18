package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.PropertyReader;

import java.util.List;

public class HotelsPage extends BasePage {

    public static final String REQUIRED_REVIEW_SCORE="hotel.review.score";

//TODO Will complete
    @FindBy(xpath = "//div[@class='bui-review-score c-score bui-review-score--end']//div[@class='bui-review-score__badge']")
    private List<WebElement> hotelsReviewScore;

    public HotelsPage(WebDriver driver) {
        super(driver);
    }

    public long findRequiredReviewScore(){
//        List<WebElement> hotelList = driver.findElements(By.xpath("//div[@class='bui-review-score c-score bui-review-score--end']/div[contains(text(),"
//                + PropertyReader.getProperty(REQUIRED_REVIEW_SCORE) +")]"));
        return hotelsReviewScore.stream().filter(element -> element.getText().contains(PropertyReader.getProperty(REQUIRED_REVIEW_SCORE))).count();
    }


//    private double parseStringToDouble(String str){
//        return Double.parseDouble(str);
//    }
}

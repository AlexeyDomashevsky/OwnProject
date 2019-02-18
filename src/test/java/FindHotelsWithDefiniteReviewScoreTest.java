import org.testng.Assert;
import org.testng.annotations.Test;
import steps.MainStep;

public class FindHotelsWithDefiniteReviewScoreTest extends BaseTest{

//    private MainStep mainStep;

    @Test
    public void verifySearchHotels(){

        MainStep mainStep = new MainStep(driver);
        mainStep.initBrowser();
        mainStep.changeLanguage();
        mainStep.fillFieldsToFindOutHotels();
        mainStep.clickSearchButton();
        mainStep.clickSearchButton();
        long actual = mainStep.getCountOfRequiredHoitels();
        testLogger.info(actual+"in test");
        Assert.assertTrue(actual>=3);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainStep.closeBrowser();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

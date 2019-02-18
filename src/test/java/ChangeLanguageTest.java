import org.testng.Assert;
import org.testng.annotations.Test;
import services.PropertyReader;
import steps.MainStep;

public class ChangeLanguageTest extends BaseTest{

    private static final String REQUIRED_LANG = "required.language";

    @Test
    public void verifyLanguageChanged (){
        MainStep mainStep = new MainStep(driver);
        testLogger.info("MainStep mainStep = new MainStep();" + driver);
        mainStep.initBrowser();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainStep.changeLanguage();

        String usedLanguage = mainStep.getSelectedLanguage();
        testLogger.info("language returned = " + usedLanguage + "language required = "+ PropertyReader.getProperty(REQUIRED_LANG));
        Assert.assertEquals(usedLanguage, PropertyReader.getProperty(REQUIRED_LANG));
    }
}

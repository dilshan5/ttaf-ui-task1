package pages;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import panels.AmazonHeaderPanel;

/**
 * Created by DilshanF on 20/11/2020.
 */
public class AmazonLoginPage extends BasicPage {
    private AmazonHeaderPanel amazonHeaderPanel;

    /**
     * Initialize AmazonLoginPage elements
     *
     * @param driver
     * @throws Exception
     */
    public AmazonLoginPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
        amazonHeaderPanel = new AmazonHeaderPanel(driver);
    }

    public boolean verify_Current_Page() throws Exception {
        return driver.getCurrentUrl().toLowerCase().contains("/ap/signin?");
    }
}

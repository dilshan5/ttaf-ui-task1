package pages;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import panels.AmazonHeaderPanel;
import panels.AmazonSidePanel;

import java.util.logging.Logger;

/**
 * Created by DilshanF on 20/11/2020.
 */
public class SearchResultsPage extends BasicPage {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchResultsPage.class));
    public AmazonHeaderPanel amazonHeaderPanel;
    public AmazonSidePanel amazonSidePanel;
    private WebDriverWait wait = new WebDriverWait(driver, 100);

    @FindBy(id = "s-result-count")
    private WebElement search_keyword;

    @FindBy(css = "div.s-main-slot.s-result-list.s-search-results.sg-row")
    private WebElement products;

    @FindBy(css = "ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-medium")
    private WebElement brand;

    public SearchResultsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
        amazonHeaderPanel = new AmazonHeaderPanel(driver);
        amazonSidePanel = new AmazonSidePanel(driver);
    }

    public boolean verify_Current_Page() throws Exception {
        return driver.getCurrentUrl().toLowerCase().contains("/s?k");
    }

    public boolean verify_SearchResults_Keyword(String key) throws Exception {
        return driver.getCurrentUrl().toLowerCase().contains("/s?k=" + key);
    }

    public void click_on_any_product(int index) {
        wait.until(ExpectedConditions.visibilityOf(products));//wait until all the products are displayed
        products.findElements(By.className("s-result-item")).get(index).findElements(By.tagName("a")).get(0).click();
    }

}

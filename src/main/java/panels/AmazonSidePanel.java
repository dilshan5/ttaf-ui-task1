package panels;

import com.automation.qa.ttafuicore.page.BasicPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created by DilshanF on 20/11/2020.
 */
public class AmazonSidePanel extends BasicPage {
    private WebDriverWait wait = new WebDriverWait(driver, 100);
    @FindBy(css = "div.a-section.a-spacing-double-large")
    private WebElement sidePanel;

    @FindBy(css = "div#brandsRefinements.a-section.a-spacing-none")
    private WebElement brands;


    /**
     * Initialize AmazonHeaderPanel elements
     *
     * @param driver
     * @throws Exception
     */
    public AmazonSidePanel(RemoteWebDriver driver) throws Exception {
        super(driver);
        //Initialize Elements
        PageFactory.initElements(driver, this);
    }


    public void select_popular_brands() {
        sidePanel.findElements(By.cssSelector("div#brandsRefinements.a-section.a-spacing-none")).get(0).
                findElements(By.cssSelector("ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-medium")).get(0).
                findElement(By.tagName("a")).click();
        wait.withTimeout(Duration.ofSeconds(5));
    }

    public void select_any_brand() {
        sidePanel.findElements(By.cssSelector("div#brandsRefinements.a-section.a-spacing-none")).get(0).
                findElements(By.cssSelector("ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-medium")).get(1).
                findElement(By.tagName("a")).click();
        wait.withTimeout(Duration.ofSeconds(5));

    }

    public void select_by_price(String priceRange) {
        sidePanel.findElements(By.cssSelector("div#priceRefinements.a-section.a-spacing-none")).
                get(0).findElement(By.linkText(priceRange)).click();
        wait.withTimeout(Duration.ofSeconds(5));
    }
}

package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import pages.AddCartPage;

/**
 * Created by DilshanF on 20/11/2020
 */
public class AddCartPageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(AddCartPageSteps.class));
    private RemoteWebDriver driver = DriverManager.getDriver();
    private AddCartPage addCartPage;

    @When("^I click on \"([^\"]*)\" button on Cart page$")
    public void i_click_on_button_on_Cart_page(String arg1) throws Throwable {
        Reporter.log(" When I click on '" + arg1 + "'' button on Cart page");
        addCartPage = new AddCartPage(driver);
        addCartPage.amazonHeaderPanel.click_Add_to_cart();//click the Add to cart icon from the headerPanel
        LOGGER.info("I am on the Add to Cart Page");
        addCartPage.click_proceed_to_checkout();
        LOGGER.info("I clicked on the 'Proceed to checkout' button.");
    }

    @Then("I remove a product from the Cart")
    public void i_remove_a_product_from_the_Cart() throws Exception {
        addCartPage = new AddCartPage(driver);
        addCartPage.remove_product();
        LOGGER.info("I removed a product from the Cart.");
    }
}

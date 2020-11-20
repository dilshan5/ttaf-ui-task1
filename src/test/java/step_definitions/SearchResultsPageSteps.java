package step_definitions;

import com.automation.qa.ttafuicore.driver.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.AmazonHomePage;
import pages.ProductDisplayPage;
import pages.SearchResultsPage;

import java.util.List;

/**
 * Created by DilshanF on 20/11/2020.
 */
public class SearchResultsPageSteps {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchResultsPageSteps.class));
    private RemoteWebDriver driver = DriverManager.getDriver();
    private SearchResultsPage searchResultsPage;
    private AmazonHomePage amazonHomePage;
    private ProductDisplayPage productDisplayPage;
    private static String searchKeyword = "";

    @Then("^I should be in Search Result page$")
    public void i_should_be_in_page() throws Throwable {
        Reporter.log("Then I should be in Search Result page");
        searchResultsPage = new SearchResultsPage(driver);
        boolean pageType = searchResultsPage.verify_Current_Page();
        Assert.assertTrue(pageType, "Navigate to invalid Page.");
        LOGGER.info("I am on the Search Result page");
    }


    @Then("^Page should have search keyword as \"([^\"]*)\"$")
    public void page_should_have_search_keyword_as(String searchKey) throws Throwable {
        Reporter.log("And Page should have search keyword as '" + searchKey + "'");
        searchKeyword = searchKey;
        boolean keyWord = searchResultsPage.verify_SearchResults_Keyword(searchKey);
        Assert.assertTrue(keyWord, "Expected keyWord is Not Found");
        LOGGER.info("I verified the Search keyword");
    }

    @When("^I click on \"([^\"]*)\" Product Thumbnail in search results page$")
    public void i_click_on_Product_Thumbnail_in_search_results_page(String step) throws Throwable {
        Reporter.log("And I click on '" + step + "' Product Thumbnail in search results page");
        switch (step) {
            case "first":
                searchResultsPage.click_on_any_product(1);
                break;
        }
        productDisplayPage = new ProductDisplayPage(driver);
        LOGGER.info("I clicked on " + step + " Item");
    }


    @Then("I search for following criteria and ADD the one item of each")
    public void i_search_for_following_criteria_and_ADD_the_one_item_of_each(DataTable table) throws Throwable {
        List<List<String>> list = table.asLists(String.class);
        amazonHomePage = new AmazonHomePage(driver);

        //Write the code to handle Data Table
        for (int i = 0; i < list.size(); ) {
            System.out.println(list.get(i).get(0));
            i_filter_the_Products_by(list.get(i).get(0));
            i_click_on_Product_Thumbnail_in_search_results_page("first");//click on the Nth item
            productDisplayPage.verify_Current_Page();
            productDisplayPage.add_item();//add the item to Cart
            i++;
            if (i < list.size())
                amazonHomePage.amazonHeaderPanel.search_for(searchKeyword);
            LOGGER.info("Added a product on " + searchKeyword + " based on " + list.get(i).get(0));
        }
    }

    @Then("I filter the Products by \"([^\"]*)\"")
    public void i_filter_the_Products_by(String category) throws Exception {
        Reporter.log("Then I filter the Products by " + category);
        switch (category) {
            case "Popular Brands":
                searchResultsPage.amazonSidePanel.select_popular_brands();
                break;
            case "Any Brand":
                searchResultsPage.amazonSidePanel.select_any_brand();
                break;
            case "Price":
                searchResultsPage.amazonSidePanel.select_by_price("Under $25");
                break;
        }
        LOGGER.info("Then I filtered the Products by " + category);
    }

    @Then("I navigate to Cart page")
    public void i_navigate_to_Cart_page() throws Exception {
        amazonHomePage.amazonHeaderPanel.click_Add_to_cart();
        LOGGER.info("I navigated to Cart page");
    }

}

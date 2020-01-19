package TestingSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static TestingSteps.OtherSteps.*;


public class BrowserFunctionsSteps {
    private WebDriverWait wait;
    private JavascriptExecutor js;



    @Given("User open (.+) page$")
    public void openWebsite(String url) {
        OtherSteps.openURL(url);
    }

    @Then("User searching in google: (.*)$")
    public void Googlesearch(String page) {
        driver().findElement(By.name("q")).sendKeys(page);
        driver().findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^User check that the (.+) website can be found using google search engine$")
    public void user_check_that_website_can_be_found_using_google_search_engine(String page) throws InterruptedException {
        Thread.sleep(10000);
        WebElement link = driver().findElement(By.xpath("//cite[contains(text(),'" + page + ".com/')]"));
        System.out.println("" + page + ".com can be found?" + link.isDisplayed());
    }

    @Then("^Enter the (.+) website through google search results$")
    public void enter_the_website_through_google_search_results(String page) {
        WebElement link = driver().findElement(By.xpath("//cite[contains(text(),'" + page + ".com/')]"));
        boolean displayed = link.isDisplayed();
        if (displayed) {
            link.click();
        } else {
            System.out.println("Page cannot be found");
        }
    }

    @Then("^Scroll up by (.+)$")
    public void scroll_up(String scroll){
        js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollBy(0,-"+scroll+");");
    }

    @Then("^Scroll down by (.+)$")
    public void scroll_down(String scroll){
        js = (JavascriptExecutor) driver();
        js.executeScript("window.scrollBy(0,"+scroll+");");
    }

    @Then("^Capture a screenshot$")
    public void Capture_a_screenshot_of_the_displayed_products_list() throws IOException, InterruptedException {
        takeScreenshot();
    }
    @Then("^Refresh$")
    public void refresh() {
        Refresh();
    }

    @Then("^Capture ID's form website$")
    public void Capture_ID_from_website(){
        showIDs();
    }

    @Then("^Write ID's to the file. Path (.*)$")
    public void Write_ID_to_the_file(int path) throws IOException {
        writeIDs(path);
    }
}
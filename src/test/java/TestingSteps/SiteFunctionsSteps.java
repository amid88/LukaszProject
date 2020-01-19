package TestingSteps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;


import static TestingSteps.OtherSteps.*;

public class SiteFunctionsSteps {
    private WebDriverWait wait;
    private Actions action;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileInputStream fs;
    private BufferedReader br;



    private static By face = By.className("facebook");
    private static By twitter = By.className("twitter");
    private static By yt = By.className("youtube");
    private static By google = By.className("google-plus");
    private static By CartProductsPrice = By.id("layer_cart_product_price");
    private static By TotalProducts = By.xpath("//span[@class='ajax_block_products_total']");
    private static By total = By.xpath("//span[@class='ajax_block_cart_total']");
    private static By contact = By.xpath("//a[@title='Contact Us']");
    private static By sign = By.xpath("//a[@title='Log in to your customer account']");
    private static By best = By.xpath("//a[@class='blockbestsellers']");
    private static By popular = By.xpath("//a[@class='homefeatured']");
    private static List<WebElement> nazwy = driver().findElements(By.xpath("//a[@class='product-name']"));
    private static List<WebElement> ceny = driver().findElements(By.xpath("//span[@class='price product-price']"));
    private static By Qty = By.xpath("//td[@class='cart_quantity text-center']//input[2]");
    private static By Qty2 = By.xpath("//span[@id='summary_products_quantity']");
    private static By Qty3 = By.xpath("//span[@id='summary_products_quantity']");
    private static By Cena = By.xpath("//td[@id='total_product']");
    private static By plus = By.xpath("//i[@class='icon-plus']");
    private static By minus = By.xpath("//i[@class='icon-minus']");
    private static By addToKart = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]");
    private static By addToKart2 = By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]");
    private static By item = By.xpath("//./a[@title='Faded Short Sleeve T-shirts'][contains(text(),'Faded Short Sleeve T-shirts')]");
    private static By lista = By.xpath("//select[@id='id_contact']");
    private static By lista1 = By.xpath("//option[@value='2']");
    private static By mail = By.xpath("//input[@id='email']");
    private static By order = By.xpath("//input[@id='id_order']");
    private static By file = By.xpath("//input[@id='fileUpload']");
    private static By text = By.xpath("//textarea[@id='message']");
    private static By send = By.xpath("//button[@id='submitMessage']");
    private static By errorText = By.xpath("//p[contains(text(),'There is 1 error')]");
    private static By proceed = By.xpath("//a[@title='Proceed to checkout']//span");
    private static By isPresent = By.xpath("//p[@class='alert alert-success']");
    private static By mailField = By.xpath("//input[@id='email_create']");
    private static By create = By.xpath("//button[@id='SubmitCreate']");
    private static By iframe = By.className("fancybox-iframe");
    private static By account = By.xpath("//h1[@class='page-heading']");


    public SiteFunctionsSteps() throws IOException {
        fw = new FileWriter("C:\\Users\\l_kunecki\\Desktop\\TestScenario7.txt");
        bw = new BufferedWriter(fw);
        fs = new FileInputStream("C:\\Users\\l_kunecki\\Desktop\\TestScenario7.txt" );
        br = new BufferedReader(new InputStreamReader(fs));
    }

    @Then("User verify if buttons are displayed in the footer$")
    public void Buttons_are_displayed() {
        System.out.println("Is Facebook present on the footer?: " + driver().findElement(face).isDisplayed());
        System.out.println("Is Twitter present on the footer?: " + driver().findElement(twitter).isDisplayed());
        System.out.println("Is Youtube present on the footer?: " + driver().findElement(yt).isDisplayed());
        System.out.println("Is Google+ present on the footer?: " + driver().findElement(google).isDisplayed());
    }

    @Then("Enter the (.+) category$")
    public void enter_the_category(String category){
        for (int i = 0; i <=5; i++) {
            try {
                driver().findElement(By.xpath("//a[@title='" + category + "']")).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Then("Verify that subcategory is available: (.+)$")
    public void verify_that_subcategories_are_available(String sub) throws InterruptedException {
        Thread.sleep(3000);
        WebElement subcat = driver().findElement(By.xpath("//a[@class='subcategory-name'][contains(text(),'" + sub + "')]"));
        System.out.println("TOPS category present on the site?: " + subcat.isDisplayed());
    }

    @Then("User add first item to cart Type: (.+)$")
    public void User_add_first_item_to_cart(int type) throws InterruptedException {

                action = new Actions(driver());
                action.moveToElement(driver().findElement(item)).build().perform();
                Thread.sleep(2000);
                switch (type) {
                    case 1:
                        driver().findElement(addToKart).click();
                        break;
                    case 2:
                        driver().findElement(addToKart2).click();
                        break;
                }
    }

    @Then("Item price and total price are correctly displayed$")
    public void Item_price_and_total_price_are_correctly_displayed() {
        boolean isEqual = driver().findElement(CartProductsPrice).getText().equals(driver().findElement(TotalProducts).getText());
        boolean isEqual2 = driver().findElement(TotalProducts).getText().equals(driver().findElement(total).getText());
        System.out.println("Item price is correctly displayed?: " + isEqual);
        System.out.println("Total price is correctly displayed?: " + isEqual2);

    }

    @Then("Proceed to checkout$")
    public void proceed() throws InterruptedException {
        Thread.sleep(5000);
        driver().findElement(proceed).click();
    }


    @Then("On the summary page, user verify that buttons work for changing item quantity$")
    public static void On_the_summary_page_verify_that_buttons_work_for_changing_item_quantity() throws InterruptedException {
        System.out.println(driver().findElement(Qty).isDisplayed());
        System.out.println("Ilość przedmiotów: " + driver().findElement(Qty).getText() + " Cena: " + driver().findElement(Cena).getText());
        System.out.println("Klikam +");
        driver().findElement(plus).click();
        Thread.sleep(5000);
        System.out.println("Nowa ilość: " + driver().findElement(Qty2).getText() + " Cena: " + driver().findElement(Cena).getText());
        System.out.println("Klikam -");
        driver().findElement(minus).click();
        Thread.sleep(5000);
        System.out.println("Nowa ilość: " + driver().findElement(Qty3).getText() + " Cena: " + driver().findElement(Cena).getText());
    }

    @Then("Open the (.+) section$")
    public void Open_the_section(String section) {
        if (section.equals("Contact")) {
            driver().findElement(contact).click();
        }
        else if (section.equals("Sign in")){
            driver().findElement(sign).click();
        }
    }

    @Then("^Send a message using the form$")
    public void Send_a_message_using_the_form(){
        driver().findElement(lista).click();
        driver().findElement(lista1).click();
        driver().findElement(mail).sendKeys("test@test.pl");
        driver().findElement(order).sendKeys("Test");
        driver().findElement(file).sendKeys(fileUpload());
        driver().findElement(text).sendKeys(testMessage());
        driver().findElement(send).click();
    }

    @Then("^Verify that all fields correctly accept inputs$")
    public void Verify_that_all_fields_correctly_accept_inputs() {
        boolean success = driver().findElement(isPresent).isDisplayed();
        if (success){
            System.out.println("Success");
        }else{
            System.out.println(driver().findElement(errorText).getText());
        }
    }

    @Then("^Open the (.+) section -clothes-$")
    public void Open_the_clothes_section(String section) {
        if (section.equals("Bestsellers")) {
            driver().findElement(best).click();
        }
        else if (section.equals("Popular")) {
            driver().findElement(popular).click();
        }
    }

    @Then("^Log the names and prices of all displayed products to console, and to a txt file$")
    public void Log_the_names_and_prices_of_all_displayed_products_to_console_and_to_a_txt_file() throws IOException {
        fw = new FileWriter("C:\\Users\\l_kunecki\\Desktop\\Test.txt");
        bw = new BufferedWriter(fw);
        for (WebElement nazwa:nazwy) {
            bw.write(nazwa.getText());
            System.out.println(nazwa.getText());
        }
        for(WebElement cena:ceny){
            bw.write(cena.getText());
            System.out.println(cena.getText());
        }
        bw.close();
    }

    @Then("^Create an account$")
    public void Create_an_account() throws IOException {
        String mail = getRandomString(5);
        bw.write(mail+ "@test.com");
        bw.newLine();
        driver().findElement(mailField).sendKeys(mail+ "@test.com");
        driver().findElement(create).click();
    }

    @Then("^Fill all fields on the form$")
    public void Fill_all_fields_on_the_form() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver().findElement(By.xpath("//input[@id='id_gender1']")).click(); //wybor plci
        driver().findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(getRandomString(6)); //imię
        driver().findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(getRandomString(8)); // nazwisko
        String password = getRandomString(9);
        bw.write(password);
        driver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(password); // hasło
        OtherSteps.date(23,"September",1991);
        driver().findElement(By.xpath("//input[@id='address1']")).sendKeys(getRandomString(10)); //adres
        driver().findElement(By.xpath("//input[@id='city']")).sendKeys(getRandomString(10)); //miasto
        driver().findElement(By.xpath("//select[@id='id_state']/option[@value='5']")).click(); //stan
        driver().findElement(By.xpath("//input[@id='postcode']")).sendKeys(getRandomInt(5)); // zip code
        driver().findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(getRandomInt(9));
        driver().findElement(By.xpath("//input[@id='alias']")).sendKeys(getRandomString(7));
        bw.close();
        driver().findElement(By.xpath("//button[@id='submitAccount']")).click(); //submit
    }

    @Then("^Confirm the account creation$")
    public void Confirm_the_account_creation() {
        System.out.println("New account created?: " + driver().findElement(account).isDisplayed());
    }

    @Then("^Logout$")
    public void Logout() {
        driver().findElement(By.xpath("//a[@title='Log me out']")).click();
    }

    @Then("^Confirm that you can log in with the newly created account$")
    public void Confirm_that_you_can_log_in_with_the_newly_created_account() throws IOException {
        String line = br.readLine();
        String line2 = br.readLine();
        driver().findElement(By.xpath("//input[@id='email']")).sendKeys(line);
        driver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(line2);
        driver().findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        driver().quit();
    }

    @Then("^Create an account with data provided in the test file$")
    public void Create_an_account_with_data_provided_in_the_test_file() throws IOException, InterruptedException {


//        sign.click();
        String mail = getRandomString(5);
        driver().findElement(mailField).sendKeys(mail+ "@test.com");
        SetCellData(1,mail +"@test.com",1,0);
        driver().findElement(create).click();
        Thread.sleep(2000);
        driver().findElement(By.xpath("//input[@id='id_gender1']")).click(); //wybor plci
        driver().findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(ReceiveCellData(1,3)); //imię
        driver().findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(ReceiveCellData(1,4)); // nazwisko
        String password = getRandomString(9);
        SetCellData(1,password,1,1);
        driver().findElement(By.xpath("//input[@id='passwd']")).sendKeys(password); // hasło
        OtherSteps.date(13,"May",1991);
        driver().findElement(By.xpath("//input[@id='address1']")).sendKeys(ReceiveCellData(1,7)); //adres
        driver().findElement(By.xpath("//input[@id='city']")).sendKeys(ReceiveCellData(1,8)); //miasto
        driver().findElement(By.xpath("//select[@id='id_state']/option[@value='5']")).click(); //stan
        driver().findElement(By.xpath("//input[@id='postcode']")).sendKeys(ReceiveCellData(1,10)); // zip code
        driver().findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(ReceiveCellData(1,11));
        driver().findElement(By.xpath("//input[@id='alias']")).clear();
        driver().findElement(By.xpath("//input[@id='alias']")).sendKeys(ReceiveCellData(1,12));
        driver().findElement(By.xpath("//button[@id='submitAccount']")).click(); //submit
    }

    @Then("^Complete the shopping process$")
    public void Complete_the_shopping_process() {
        driver().findElement(By.xpath("//p[@class='cart_navigation clearfix']//span")).click();
        driver().findElement(By.xpath("//button[@name='processAddress']")).click();
        driver().findElement(By.xpath("//input[@id='cgv']")).click();
        driver().findElement(By.xpath("//button[@name='processCarrier']")).click();
        driver().findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
        driver().findElement(By.xpath("//p[@id='cart_navigation']//button[@type='submit']")).click();
    }

    @Then("^Write the products and prices to another file$")
    public void Write_the_products_and_prices_to_another_file() throws IOException, InterruptedException {

        driver().findElement(By.xpath("//a[@title='Back to orders']")).click();
        driver().findElement(By.xpath("//td[@class='history_detail footable-last-column']//span")).click();
        Thread.sleep(5000);
        List<WebElement> products = driver().findElements(By.xpath("//label[contains(text(),'Size')]"));
        int i =0;
        for (WebElement product:products){
            i=i+1;
            SetCellData(2,product.getText(),i,0);
        }
        List<WebElement> totalPrice = driver().findElements(By.xpath("//td[5][@class='price']/label[contains(text(),'$')]"));
        int j =0;
        for (WebElement total:totalPrice){
            j=j+1;
            SetCellData(2,total.getText(),j,2);
        }
        List<WebElement> unitPrice = driver().findElements(By.xpath("//td[4][@class='price']/label[contains(text(),'$')]"));
        int k =0;
        for (WebElement unit:unitPrice){
            k=k+1;
            SetCellData(2,unit.getText(),k,1);
        }
    }

    @Then("^Back to main page$")
    public void back_to_main(){
        WebElement main = driver().findElement(By.xpath("//a[@title='Return to Home']"));
        main.click();
    }

    @Then("^Open the Quick View of any product from the list$")
    public void Open_the_Quick_View_of_any_product_from_the_list() throws InterruptedException {
        action = new Actions(driver());
        action.moveToElement(driver().findElement(item)).build().perform();
        Thread.sleep(2000);
        driver().findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Quick view')]")).click();
    }

    @Then("^Download all thumbs images of the opened product$")
    public void Download_all_thumbs_images_of_the_opened_product() throws InterruptedException, IOException {
        driver().switchTo().frame(driver().findElement(iframe));
        Thread.sleep(5000);
        OtherSteps.download("thumb");
    }

    @Then("^Log the number of downloaded images$")
    public void Log_the_number_of_downloaded_images() throws InterruptedException {

    }

}
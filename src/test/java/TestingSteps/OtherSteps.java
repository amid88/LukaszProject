package TestingSteps;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;


public class OtherSteps {
    static void openURL(String url){
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver().get("http://" + url + ".com");
        driver().manage().window().maximize();

    }

    public static WebDriver driver;
    public static WebDriver driver(){
        if (driver==null) {
            driver = new FirefoxDriver();
            return driver;
        }else{
            return driver;
        }
    }

    public static String fileUpload (){
        String path = "C:\\Users\\l_kunecki\\Desktop\\Kuna.jpg";
        return path;
    }

    public static String testMessage (){
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, \n" +
                "scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus.";
        return text;
    }

    public static TakesScreenshot scrShot;
    public static File SrcFile;
    public static File DestFile;
    public static void takeScreenshot() throws InterruptedException, IOException {
        Thread.sleep(3000);
        scrShot =((TakesScreenshot)driver);
        SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        DestFile=new File("C:\\Users\\l_kunecki\\Desktop\\Testimg.jpg");
        FileHandler.copy(SrcFile, DestFile);
    }

    public static String getRandomString(int lenght) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ";
        for (int i = 0; i < lenght; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static String getRandomInt(int lenght) {
        StringBuilder sb = new StringBuilder();
        String characters = "1234567890";
        for (int i = 0; i < lenght; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static void date (int day, String month, int year) throws InterruptedException {
        driver().findElement(By.xpath("//select[@id='days']")).click();
        driver().findElement(By.xpath("//option[@value='"+day+"'][contains(text(),'"+day+"')]")).click(); //dzien
        driver().findElement(By.xpath("//select[@id='months']")).click();
        driver().findElement(By.xpath("//option[contains(text(),'"+month+"')]")).click();
        driver().findElement(By.xpath("//select[@id='years']")).click();
        driver().findElement(By.xpath("//option[@value='"+year+"']")).click(); //rok

    }

    public static void SetCellData(int pathNumber, String result, int rowNumber, int cellNumber) throws IOException {

        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;
        XSSFRow Row;

        String path = null;

        switch(pathNumber) {
            case 1:
                path = "C:\\Users\\l_kunecki\\Desktop\\ZadaniaC\\src\\test\\java\\ExcelFile\\test.xlsx";
                break;
            case 2:
                path = "C:\\Users\\l_kunecki\\Desktop\\ZadaniaC\\src\\test\\java\\ExcelFile\\ProductList.xlsx";
                break;
            case 3:
                path = "C:\\Users\\l_kunecki\\Desktop\\ZadaniaC\\src\\test\\java\\ExcelFile\\id.xlsx";
                break;
        }


        String sheet = "Arkusz1";

        FileInputStream ExcelFile= new FileInputStream(path);
        ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheet);

        Row = ExcelWSheet.getRow(rowNumber);
        Cell = Row.getCell(cellNumber);

        if (Cell == null){
            Row.createCell(cellNumber);
        }
        else
            Cell.setCellValue(result);

        FileOutputStream fileOut = new FileOutputStream(path);
        ExcelWBook.write(fileOut);
        fileOut.close();
    }

    public static String ReceiveCellData (int rowNumber, int cellNumber) throws IOException {
        XSSFWorkbook ExcelWBoook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;


        String path = "C:\\Users\\l_kunecki\\Desktop\\ZadaniaC\\src\\test\\java\\ExcelFile\\test.xlsx";
        String sheet = "Arkusz1";

        FileInputStream ExcelFile = new FileInputStream(path);
        ExcelWBoook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBoook.getSheet(sheet);
        Cell = ExcelWSheet.getRow(rowNumber).getCell(cellNumber);

        return String.valueOf(Cell);
    }

    public static String attribute;

    public static String showIDs() {

        List<WebElement> ids = driver().findElements(By.xpath("//*[@id]"));
        int i = 0;
        for (WebElement id : ids) {
            i = i + 1;
            System.out.println(id.getAttribute("id"));
        }
        return null;
    }

    public static String writeIDs(int pathNumber) throws IOException {

        List<WebElement> ids = driver().findElements(By.xpath("//*[@id]"));
        int i = 0;
        for (WebElement id : ids) {
            i = i + 1;
            System.out.println(id.getAttribute("id"));
            attribute = id.getAttribute("id");
            OtherSteps.SetCellData(pathNumber, attribute, i, 0);
        }
        return null;
    }

    public static void download(String id) throws IOException {
        List<WebElement> images = driver().findElements(By.xpath("//img[contains(@id, '"+id+"')]"));

        int i=0;
        for(WebElement image:images){
            i=i+1;
            String imagesrc = image.getAttribute("src");
            URL imageURL = new URL(imagesrc);
            BufferedImage saveImage = ImageIO.read(imageURL);
            ImageIO.write(saveImage, "png", new File("C:\\Users\\l_kunecki\\Desktop\\"+ OtherSteps.getRandomString(4) +".jpg"));
        }
        System.out.println("Numbers of downloaded images: " + i);
    }

    public static void Refresh(){
        driver().navigate().refresh();
    }
}

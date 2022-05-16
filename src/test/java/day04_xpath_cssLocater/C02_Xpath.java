package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
      /*  1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        // (//img[@class='s-image'] */
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe" );
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // 2- Add Element butonuna basin
        // driver.findElement(By.xpath("//buton[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
// 3  Delete butonu’nun gorunur oldugunu test edin
        WebElement deletebutonuvarMi= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deletebutonuvarMi.isDisplayed()){
            System.out.println(" Passed");
        } else {
            System.out.println("Yok ");
        }
        Thread.sleep(2000);
//       4- Delete tusuna basin
        deletebutonuvarMi.click();

       // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveYazisiElementi= driver.findElement(By.xpath("//h3"));
        if (addRemoveYazisiElementi.isDisplayed()){
            System.out.println("Passed = ");
        }else{
            System.out.println("FaİLD = ");

        } driver.close();
    }
}

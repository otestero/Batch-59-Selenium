package day03_locator;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class C04_WebElementMetotlari {
    public static void main(String[] args) {
        //amazon.com'a gidip arama kutusunu locate edin
        // arama kutusunu tagName inin input olduğunu test edin
        // arama kutusunun name attribute nun değerinin field-keywords olduğunu test edin

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazon.com'a gidip arama kutusunu locate edin
        driver.get("https://www.amazon.com");
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusunu tagName inin input olduğunu test edin
        String expectedTagName ="input";
        String actualTagNmae=aramakutusu.getTagName();
        if (expectedTagName.equals(actualTagNmae)){
            System.out.println("actualTagNmae testi PASS ");
        }else {
            System.out.println("actualTagNmae testi FAİLD ");
        }
// arama kutusunun name attribute nun değerinin field-keywords olduğunu test edin
        String expevtedNameDegeri= "field-keywords";
        String actualnameAttibuteDegeeri=aramakutusu.getAttribute("name");
        if (expevtedNameDegeri.equals(actualnameAttibuteDegeeri)){
            System.out.println("name PASSED");
        }else{
            System.out.println("name Kaldı " );
        }
        driver.close();
    }
}


package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XpathV1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe" );
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basabilmek için;
        // web sayfasında butonun üstünde sağ tıkla "incpect" inceleye bas.kodaların kaynağı gelecektir.
        // tam yerini bulmak için butonun üstünde tekrar sağ tık ve incpect yaparız. ilgili kod bloğu gelir.
        // 8 tane locater vardır. By.id(en fazla kullanılır), By.name(), By.classname(genelde uniq değildir. bosluk varsa çalışmayabilir), By.LinkTest, By.tagName(genelde uniq değildir.), By.Xpath(En etkin yoldur), By.cssSelector().
        // driver.findElement(By.xpath("//tagName[@AntributeIsmi='AntributeValue']"));
        // driver.findElement(By.xpath("//button[@class='added-manually']"));
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        // 3  Delete butonu’nun gorunur oldugunu test etmek için;
        WebElement deletebutonuvarMi = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deletebutonuvarMi.isDisplayed()){
            System.out.println(" Passed");
        } else {
            System.out.println("FAİLD ");
        }

        // Sayfada 2 sn beklemek için;
        Thread.sleep(2000);

        // 4- Delete tusuna basmak için
        deletebutonuvarMi.click();
        driver.close();
        }
    }


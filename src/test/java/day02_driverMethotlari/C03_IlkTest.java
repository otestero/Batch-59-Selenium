package day02_driverMethotlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTest {
    public static void main(String[] args) {
        /*  1- https://www.amazon.com url'ine gidin
    2- Basligin Amazon kelimesi icerdigini test edin
    3- Url'in "https://www.amazon.com" a esit oldugunu test edin
    4- sayfayi kapatin
 */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//tam ekran yapmak için
        // 1
        driver.get("https://www.amazon.com");
        //2
        String actualTitle= driver.getTitle();
        String arananKelime="Amazon";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Gecti");
        }else System.out.println("Title "+ arananKelime+" yi içermiyor");

        //3
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com";
        if (actualUrl.equals(expectedUrl)){

        }

    }
}

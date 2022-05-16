package day02_driverMethotlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_manageMetotlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
/*
Ilerde wait konusunu daha genis olarak ele alacagiz
Bir sayfa acilirken, ilk basta sayfanin icerisinde bulunan elementlere gore bir yuklenme suresine ihtiyac vardir.
veya bir webelementinin kullanılabilmesi için zamana ihtiyaç olabilir.
implicitlyWait bize sayfanın yüklenmesi ve sayfadaki elemenntlere ulaşım için beklenecek MAXIMUM süreyi belirleme olanığı tanir.

 */
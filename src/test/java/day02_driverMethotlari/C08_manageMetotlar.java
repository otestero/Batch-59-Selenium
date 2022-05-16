package day02_driverMethotlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_manageMetotlar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("maximaze konum = " + driver.manage().window().getPosition());
        System.out.println("maximize boyut = " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();

        System.out.println("fullscreen konum = " + driver.manage().window().getPosition());
        System.out.println("fullscreen boyut = " + driver.manage().window().getSize());
    }
}

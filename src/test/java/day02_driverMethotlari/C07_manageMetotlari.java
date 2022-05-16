package day02_driverMethotlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_manageMetotlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        System.out.println("pencere ölçüleri = " + driver.manage().window().getSize());//(1050, 660)
        System.out.println("getPosition() = " + driver.manage().window().getPosition());// (10, 10)
        driver.manage().window().setPosition(new Point(15,15));
   driver.manage().window().setSize(new Dimension(600,900));
   driver.close();
    }
}

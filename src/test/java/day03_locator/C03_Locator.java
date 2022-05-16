package day03_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://a.testaddressbook.com");
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement emailPasswordText = driver.findElement((By.name("session[password]")));
        WebElement singInButonu = driver.findElement(By.name("commit"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        emailPasswordText.sendKeys("Test1234!");
        singInButonu.click();

        WebElement actualKullaniciAdiElemnti = driver.findElement(By.className("navbar-text"));
        System.out.println("actualKullaniciAdi = " + actualKullaniciAdiElemnti.getText());
        String expectedUserMail = "testtechproed@gmail.com";
        if (expectedUserMail.equals(actualKullaniciAdiElemnti.getText())) {
            System.out.println("expected Kullanıcı Testi PASSED ");
        } else System.out.println("expected Kullanıcı Testi Faild ");

        WebElement adressesElementi = driver.findElement(By.linkText("Addresses"));
        WebElement singOutElementi = driver.findElement(By.linkText("Sign out"));
        if (adressesElementi.isDisplayed()) {
            System.out.println("adresses Elementi testi PASSED ");
        } else {
            System.out.println("adresses Elementi testi FAİLD ");
        }
        if (singOutElementi.isDisplayed()) {
                System.out.println("singOut Elementi testi PASSED ");
        } else {
                System.out.println("singOut Elementi testi FAİLD ");
            }
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
                System.out.println("linklerListesi sayısı = " + linklerListesi.size());
        for (WebElement each:linklerListesi
             ) {
            System.out.println("each = " + each.getText());
        }
        driver.close();
            }
        }
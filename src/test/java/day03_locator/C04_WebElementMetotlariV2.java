package day03_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_WebElementMetotlariV2 {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("Kullanacağımız driver", "driverın bilgisayarımızdaki yerini gösteren yol/path");
        // System.setProperty("webdriver.chrome.driver-elle yaz", "chromedriver.exe-sağtıkla-Copy/Path Referance-Path from content Root' u seç-CTRL-V ile yapıştır");
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        // File-Project Structure-(Modules seç-Dependencies seç-(+) bas- JAR or Directory seç-Projenin adını bulu "Batch59Selenium" seç-src-resources-libraries "altındaki tüm dosyaları" seç-Ok-Apply-Ok
        WebDriver driver=new ChromeDriver();

        // Açılan sayfayı Tam ekran yapmak için:
        driver.manage().window().maximize();

        // Sayfanın yüklenmesi için gereken süre max süre(15):
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon.com'a gidebilmek için
        driver.get("https://www.amazon.com");

        // findElement (By ... ) herhangi bir Web elementine gitmek için
        /* aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(2000);*/

        // "https://www.amazon.com" gittikten sonra arama kutusunu locate edebilmek için
        // WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusu sources (kaynak kodlarını) Stringe atamak için
        String expectedTagName = "input";
        String actualTagName=aramakutusu.getTagName();

        // arama kutusunu tagName inin "input" olduğunu test edebilmek için
        if (expectedTagName.equals(actualTagName)){
            System.out.println("actualTagNmae testi PASS ");
        }else {
            System.out.println("actualTagNmae testi FAİLD ");
        }
        // arama kutusunun "name attribute" nun değerinin "field-keywords" olduğunu test etmek için;
        String expectedNameDegeri ="field-keywords";
        String actualnameAttibuteDegeeri = aramakutusu.getAttribute("name");
        if (expectedNameDegeri.equals(actualnameAttibuteDegeeri)){
            System.out.println("name PASSED");
        }else{
            System.out.println("name Kaldı " );
            }
        //driver.close();
        // Add Element butonuna basabilmek için; web sayfasında butonun üstünde sağ tıkla "incpect" inceleye bas. Kodaların kaynağı gelecektir. Tam yerini bulmak için butonun üstünde tekrar sağ tık ve incpect yaparız. İlgili kod bloğu gelir.
        // 8 tane "LOCATER" vardır. By.id(en fazla kullanılır), By.name(), By.classname(genelde uniq değildir. bosluk varsa çalışmayabilir), By.LinkTest, By.tagName(genelde uniq değildir.), By.Xpath(En etkin yoldur), By.cssSelector().
        // driver.findElement(By.xpath("//tagName[@AntributeIsmi='AntributeValue']"));
        // driver.findElement(By.xpath("//button[@class='added-manually']"));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

       // Delete butonu’nun gorunur oldugunu test etmek için; "isDisplayed()"
       // driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
       // driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        WebElement deletebutonuvarMi = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deletebutonuvarMi.isDisplayed()){
            System.out.println(" Passed");
        } else {
            System.out.println("FAİLD ");
        }
        //  Delete tusuna basmak için
        deletebutonuvarMi.click();
        Thread.sleep(2000);

        //  Elementleri By.cssSelector ile locate etmek için: By.cssSelector(tagName[attributename='value']
        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement mailTextBox= driver.findElement(By.cssSelector("#session_email"));//	b. Locate email textbox
        WebElement passwordTextBox= driver.findElement(By.cssSelector("#session_password"));//	c. Locate password textbox ve
        WebElement signInButonu= driver.findElement(By.cssSelector("input[value='Sign in']"));//	d. Locate signin button

        //	Asagidaki kullanıcı adını ve şifreyi ilgili textBox'a girebilmek için (göndermek);
        //		i. Username : testtechproed@gmail.com
        //		ii. Password : Test1234!
        mailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");

        // sign in düğmesini tıklamak için;
        signInButonu.click();

        // amazon.com'a gidebilmek için
        driver.get("https://www.amazon.com");
        // "https://www.amazon.com" gittikten sonra arama kutusunu locate edebilmek için
        aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // b. Search(ara) kutusuna “city bike” yazdırıp Enter'a basıp ilgili sayfayı getirmek için;
        aramakutusu.sendKeys("city bike"+ Keys.ENTER);
        Thread.sleep(2000);

        // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırmak için:
        List<WebElement> istenenElementListesi = driver.findElements(By.className("sg-col-inner")) ;
        WebElement sonucYAzisiElementi=istenenElementListesi.get(0);
        System.out.println("sonucYAzisiElementi = " + sonucYAzisiElementi.getText());

        List<WebElement> urunResimleriListesi = driver.findElements(By.className("sg-col-inner")) ;
        WebElement ilkUrunResmiElementi=urunResimleriListesi.get(0);
        System.out.println(ilkUrunResmiElementi.getText());

        List<WebElement> linkListesi= driver.findElements(By.tagName("a"));
        System.out.println("linkListesi = " + linkListesi.size());

        // Açılan Web sayfasının otomatik olarak kapanması için
        driver.close();
    }
}


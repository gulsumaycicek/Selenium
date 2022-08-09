package day04_xpath_cssLocater;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_AmazonSearch {
    public static void main(String[] args) {

        /*
        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
 a.web sayfasına  https://www. amazon.com/
 b. Search(ara) “city bike”
 c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

 e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //      https://www. amazon.com/
        driver.get("https://www.amazon.com");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        //        c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> istenenElementListesi=driver.findElements(By.className("sg-col-inner"));
        WebElement sonucSayisiElementi=istenenElementListesi.get(0);
        System.out.println(sonucSayisiElementi.getText());


        //        d.Sonra karsiniza cikan ilk sonucun resmine tiklayin
        List<WebElement> urunResimlreri=driver.findElements(By.className("s-image"));
        WebElement ilkUrunResmı=urunResimlreri.get(0);
        ilkUrunResmı.click();



    }
}

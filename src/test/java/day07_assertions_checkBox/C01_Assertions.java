package day07_assertions_checkBox;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    //2) https://www.bestbuy.com/ Adresine gidin
    //   farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");


    }

    @AfterClass
    public static void teardown(){
    driver.close();
    }

    @Test
    public void urlTest(){
        //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.equals(expectedUrl));
    }

    @Test
    public void titleTest(){
        //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unexpectedIcerik="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(unexpectedIcerik));
    }

   @Test
   public void logoTest(){
       //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
       WebElement logo=driver.findElement(By.xpath("(//img[@alt = 'Best Buy Logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());
   }

   @Test
    public void FrancaisLinkTest(){
       //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

       WebElement fransizcaLink= driver.findElement(By.xpath("//button[normalize-space()='Français']"));
       Assert.assertTrue(fransizcaLink.isDisplayed());
   }
}

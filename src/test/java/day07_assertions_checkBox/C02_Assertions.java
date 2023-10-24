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

public class C02_Assertions {

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
    //   ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin

        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void imageTest(){
        //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement youtubeResim = driver.findElement(By.xpath("(//*[@class='style-scope yt-icon'])[5]"));
        Assert.assertTrue(youtubeResim.isDisplayed());

    }

    @Test
    public void searchBoxTest(){
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled()

        WebElement searchBox= driver.findElement(By.xpath("//div[@id='search-container']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();

        Assert.assertNotEquals(actualTitle,unexpectedTitle);

    }
}

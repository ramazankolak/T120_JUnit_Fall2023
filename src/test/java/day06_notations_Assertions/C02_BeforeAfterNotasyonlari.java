package day06_notations_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_BeforeAfterNotasyonlari {

    /*
        bir class'in icinde her Test Method'undan once calismasini istediginiz
        siradan bir method varsa
        o method'un basina @Before kullanirsak
        @Test method'larinda CAGIRMAYA GEREK OLMADAN
        o method her test method'undan once calisir
        Ayni sekilde her test Method'undan sonra calismasini istedigimiz
        siradan bir method varsa
        @After notasyonu ile isaretleyebiliriz
     */

    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin

    WebDriver driver=new ChromeDriver();

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.close();
    }



    @Test
    public void amazonTest(){
        //1-Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin

        driver.get("https://amazon.com");

        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Amazon url test passed");
        }else {
            System.out.println("Amazon url test failed");
        }

    }

    @Test
    public void wiseTest(){
        //2-Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin

        driver.get("https://wisequarter.com");
        String expectedTitle="Wise";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("wisequarter baslik test passed");
        }else {
            System.out.println("wisequarter baslik test passed");
        }


    }
    @Test
    public void youtubeTest(){
        // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin


        driver.get("https://youtube.com");
        String unexpectedTitle="best";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(unexpectedTitle)){
            System.out.println("youtube baslik test failed");
        }else {
            System.out.println("youtube baslik test passed");
        }

    }
}

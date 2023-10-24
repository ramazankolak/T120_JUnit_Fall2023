package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_KontrolsuzCokluWindow extends TestBase {




    @Test
    public void cokluPencereTesti(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWhd= driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> whdSeti=driver.getWindowHandles();
        String ikinciSayfaWhd="";

        for (String each: whdSeti
             ) {

            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }

        }
        driver.switchTo().window(ikinciSayfaWhd);
        expectedTitle="New Window";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        /*
        Bir linke tikladigimizda
            biz newWindow() kullanmadigimiz halde yeni sayfa aciliyorsa
            driver eski sayfada kalir
            yeni sayfada islem yapabilmek icin
            bizim driver'i yeni sayfaya gecirmemiz gerekir.
         */

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yazi2Elementi=driver.findElement(By.tagName("h3"));
        expectedYazi="New Window";
        actualYazi=yazi2Elementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWhd);
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}

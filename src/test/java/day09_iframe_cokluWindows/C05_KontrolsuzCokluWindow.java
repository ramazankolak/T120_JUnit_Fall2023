package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrolsuzCokluWindow extends TestBase {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/iframe url'ine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWhd= driver.getWindowHandle();

        // sayfa basliginin Internet icerdigini test edin
        String expectedTitle="Internet";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Elemental Selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        String ikinciSayfaWhd="";
        Set<String>whdSeti=driver.getWindowHandles();

        for (String each:whdSeti
             ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }

        driver.switchTo().window(ikinciSayfaWhd);
        expectedTitle="Selenium";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Ilk sayfaya donup url'in internet icerdigini test edin
        driver.switchTo().window(ilkSayfaWhd);

        String expectedUrl="internet";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }




}

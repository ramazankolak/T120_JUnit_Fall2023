package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        bekle(3);
        //2- Cookies kabul edin
        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement isimKutusu= driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        actions.click(isimKutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("9")
                .sendKeys(Keys.TAB)
                .sendKeys("Oca")
                .sendKeys(Keys.TAB)
                .sendKeys("1998")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();
        driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _6o _6v']")).click();

        bekle(10);
    }
}

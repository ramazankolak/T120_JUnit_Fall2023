package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void fileUploadTesti(){
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //text.txt dosyasini secelim.
        /*
            insan olarak dosya secimi icin
            chooseFile butonuna bastiktan sonra
            acilan windows dosya penceresinden
            istedigimiz dosyayi secip yukleriz.

            Selenium'da otomasyon ile bu islemi yapmak icin
            chooseFile butonu locate edilip,
            bu webelement'e sendKeys(yuklenecekDosyaninDosyaYolu); yapilir
         */

        WebElement uploadButton=driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day11_fileTestleri_Waits/text.txt";
        bekle(3);

        uploadButton.sendKeys(dinamikDosyaYolu);
        bekle(3);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        bekle(2);

        WebElement fileUploaded= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploaded.isDisplayed());


    }
}

package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {


    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaFotografCek(WebDriver driver,String resimAdi) {

        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ltd=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ltd.format(formatter);
        String dinamikDosyaYolu="target/screenshots/"+resimAdi+tarihEtiketi+".jpg";


        TakesScreenshot tss= (TakesScreenshot) driver;

        File tumSayfaSs=new File(dinamikDosyaYolu);

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementFotografCek(WebElement webElement, String resimAdi) {

        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ltd=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ltd.format(formatter);
        String dinamikDosyaYolu="target/screenshots/"+resimAdi+tarihEtiketi+".jpg";

        File tumSayfaSs=new File(dinamikDosyaYolu);

        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

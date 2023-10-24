package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileDownload extends TestBase {

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.jpg dosyasını indirelim
        bekle(2);
        driver.findElement(By.xpath("//a[text()='dummy.pdf']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(4);

        String dosyaYolu="C:\\Users\\Ramazan KOLAK\\Downloads\\dummy.pdf";


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        bekle(3);
    }
}

package day11_fileTestleri_Waits;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {
    @Test
    public void test01(){
        /*
            Testlerimizin farkli bilgisayarlarda da calismasi gerekiyorsa
            file testleri icin gerekli olan DOSYA YOLU dinamik yapilmalidir

            Java'da dosya yolunu kodun calistigi bilgisayardan
            otomatik olarak almak icin 2 secenek vardir

            System.getProperty("user.home") ===> bilgisayarin ana dosya yolunu verir
            System.getProperty("user.dir")  ===>
         */
        // masaustumuzde bulunan logo.jpg dosyasinin varligini
        // dinamik dosya yolu kullanarak test edelim

        //     "/Users/ahmetbulutluoz" +    "/Desktop/logo.jpg"
        //         Ana dosya yolu        Herkeste ayni olan kisim

        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\dummy.pdf";

        System.out.println(dinamikDosyaYolu);//C:\Users\Ramazan KOLAK\Downloads\dummy.pdf

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        System.out.println(System.getProperty("user.dir"));

        //C:\Users\Ramazan KOLAK\IdeaProjects\Team120_JUnit_Fall2023

        // projemizde var olan text.txt 'nin varligini
        // dinamik dosya yolu ile test edelim

        //C:\Users\Ramazan KOLAK\IdeaProjects\Team120_JUnit_Fall2023
        // \src\test\java\day11_fileTestleri_Waits\text.txt

        String dinamikTextDosyaYolu=System.getProperty("user.dir")+"\\src\\test\\java\\day11_fileTestleri_Waits\\text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));
    }
}

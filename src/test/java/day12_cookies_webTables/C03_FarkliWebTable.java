package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_FarkliWebTable extends TestBase {

    @Test
    public void webTableTest(){
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement>baslikElementleriList=
                driver.findElements(By.xpath("//*[@*='columnheader']"));

        for (WebElement each:baslikElementleriList
             ) {
            System.out.print(each.getText()+" ");

        }
        System.out.println("");

        //  3. 3.sutunun basligini yazdirin
        System.out.println(" 3. sutun basligi: "+baslikElementleriList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        WebElement tumBodyElementi= driver.findElement(By.xpath("//*[@*='rt-tbody']"));
        System.out.println(tumBodyElementi.getText());

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        List<WebElement>tumDataList
                =driver.findElements(By.xpath("((//*[@role='rowgroup']) //*[@role = 'gridcell'])"));
        int sayac=0;
        for (WebElement each:tumDataList
             ) {
            if (!each.getText().isBlank()){
               sayac++;
                System.out.println(sayac+"- "+each.getText());
            }
        }
        System.out.println("Bos olmayan hucre sayisi: "+sayac);

        //  6. Tablodaki satir sayisini yazdirin
        //   ((//*[@*='rowgroup'])[2]//*[@*='gridcell'])[2]

        List<WebElement> satirElementleriListesi=
                driver.findElements(By.xpath("//*[@*='rowgroup']"));

        System.out.println("Tablodaki satir sayisi: "+satirElementleriListesi.size());

        //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunElementleriListesi=
                driver.findElements(By.xpath("(//*[@*='rowgroup'])[2]//*[@*='gridcell']"));
        System.out.println("Tablodaki sutun sayisi: "+sutunElementleriListesi.size());

        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement>ucuncuKolonListesi=
                driver.findElements(By.xpath("(//*[@*='rowgroup'])//*[@*='gridcell'][3]"));

        for (WebElement each:ucuncuKolonListesi
             ) {
            if (!each.getText().isBlank()){
                System.out.println(each.getText());
            }
        }

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        String dinamikIsimLocati;
        String dinamikMaasLocati;
        String isim;
        String maas;

        for (int i = 1; i <= satirElementleriListesi.size(); i++) {

            dinamikIsimLocati="((//*[@*='rowgroup'])["+i+"]//*[@*='gridcell'])[1]";
            dinamikMaasLocati="((//*[@*='rowgroup'])["+i+"]//*[@*='gridcell'])[5]";

            isim=driver.findElement(By.xpath(dinamikIsimLocati)).getText();
            maas=driver.findElement(By.xpath(dinamikMaasLocati)).getText();

            if (isim.equals("Kierra")){
                System.out.println("Kierra'nin maasi= "+maas);
            }
        }

        // 10. bir method olusturun,
        //     satir ve sutun sayisini girdigimde bana datayi yazdirsin


    }

    public void datayiYazdir(int satirNo, int sutunNo){

    String dinamikXpath="((//*[@*='rowgroup'])["+satirNo+"]//*[@*='gridcell'])["+sutunNo+"]";

    String istenenData=driver.findElement(By.xpath(dinamikXpath)).getText();

        System.out.println(satirNo+".satir. "+sutunNo+". sutundaki bilgi : "+istenenData );

    }
}

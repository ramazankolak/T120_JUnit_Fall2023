package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void readExcelTestleri() throws IOException {

        String dosyaYolu="src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        //       olusturdugumuz workbook, online olarak excel dosyasina erismez
        //       18.satirda fileInputStream kullanarak excel'deki bilgileri aldik
        //       20.satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        //       fiziki excl dosyasinin bir kopyasini olusturmus olduk.

        Sheet sayfa1=workbook.getSheet("Sayfa1");
        Row row=sayfa1.getRow(3); //index oldugu icin sıfırdan baslar
        Cell cell=row.getCell(3);

        System.out.println(cell);

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));

        //      - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenData);

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedData="Kabil";
        String actualData=sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData,actualData);

        //		- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()+1);//190 yani son satirin indexini verir +1 ekledik satir sayisini bulmak icin

        //		- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows());//direkt fiziki olarak kullanilan satir sayisini verir

        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String isim;
        String baskent;
        Map<String,String >ulkelerMap=new TreeMap<>();

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {
            isim=sayfa1.getRow(i).getCell(0).toString();
            baskent=sayfa1.getRow(i).getCell(1).toString();

            ulkelerMap.put(isim,baskent);
        }

        // Ulkeler excel'inde Canada isimli bir ulke oldugunu test edin

        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        // Ulkeler excel'inde Cuba'nin baskentinin Havana oldugunu test edin
        String expectedBaskent="Havana";
        String actualBaskent=ulkelerMap.get("Cuba");

        Assert.assertEquals(expectedBaskent,actualBaskent);


    }
}

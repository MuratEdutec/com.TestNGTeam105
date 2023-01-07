package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C01_SoftAssert {


        @Test(groups = "minireg1")
        public void test01(){
    // amazon ana sayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");


    // amazon ana sayfaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();

        String expectedUrlKelime="amazon";
        String actualURLKelime= Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualURLKelime.contains(expectedUrlKelime));

        // Nutella aratin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


        // arama sonuclarinin nutella icerdigini dogrulayin
        String aramaSonucYazisi= amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));


        // Java aratin
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+ Keys.ENTER);

    //    ReusableMEthods.bekle(10);

       // System.out.println(amazonPage.aramaSonucuElementi.getText());
        aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();

        String [] sonucArr=aramaSonucYazisi.split(" ");

    // aram sonuclarinin 1000'den fazla oldugunu dogrulayin
                String javaSonucSayisiStr=sonucArr[3];
                javaSonucSayisiStr=javaSonucSayisiStr.replaceAll("\\W","");

                int sonucSayisiInt= Integer.parseInt(javaSonucSayisiStr);

                softAssert.assertTrue(sonucSayisiInt > 1000);
                softAssert.assertAll();
                Driver.closeDriver();





    }




}

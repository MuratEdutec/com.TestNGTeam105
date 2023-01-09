package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {


    @Test
    public void test01(){

        extentTest= extentReports.createTest("Nutella testi", "Kullanici amazonda Nutella arayabilmeli");

        // amazona gidelim
        // nutella aratalim
        // sonuclarin Nutella icerdigini test edelim

        // amazona gidelim
         Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");




         // nutella aratalim
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip, arama yapildi");
        // sonuclarin Nutella icerdigini test edelim
        String actualSonucYazisi= amazonPage.aramaSonucuElementi.getText();
        String expectedKelime= "Nutella";
        extentTest.info("Arama sonuclari kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.info("Arama sonuclarinin NUtella icerdigi tespit edildi");
    }



}
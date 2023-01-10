package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTesti {


    @Test
    public void pozitifLoginTest(){

        //quality demi ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
    ReusableMethods.bekle(2);
       qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();
        //
    }
}

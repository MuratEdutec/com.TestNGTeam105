package tests.day16_SmokeTests;

import com.github.dockerjava.api.model.CpuStatsConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLoginTesti {

    QualitydemyPage qualitydemyPage= new QualitydemyPage();


    @Test
    public void yanlisEmailTesti(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsernama"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        ReusableMethods.bekle(2);
        qualitydemyPage.loginButonu.click();

        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();


    }


    @Test
    public void yanlisPasswordTesti(){


        qualitydemyPage =new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsernama"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        ReusableMethods.bekle(2);


        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);

    }

    @Test
    public void yanlisUserNameYanlisPasswordTesti(){

        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsernama"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        ReusableMethods.bekle(2);

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);



    }






}

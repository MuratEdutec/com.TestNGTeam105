package tests.day18_htmlReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderIleNegatifLoginTesti {
    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object [] [] kullaniciBilgileriArr= {{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};




        return kullaniciBilgileriArr;
    }

    // Qualitydemy ana sayfaya gidin
    // verilen yanlis kullanici adi ve password kombinasyinlari icin
    // giris yapilamadigini test edin
    // user     password
    //A11       A12345
    //B12       B12345
    //C13       C12345
    //D14       D12345
    //E15       E12345


    @Test(dataProvider = "kullaniciBilgileri")
    public void negativeLoginTest(String username, String password) {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username+ Keys.ENTER);
        qualitydemyPage.passwordKutusu.sendKeys(password+Keys.ENTER);
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        ReusableMethods.bekle(3);
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());




        Driver.quitDriver();






    }

}

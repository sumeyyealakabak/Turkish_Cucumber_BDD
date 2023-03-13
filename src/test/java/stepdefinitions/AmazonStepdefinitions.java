package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AmazonStepdefinitions {
    AmazonPage amazonPage=new AmazonPage();

    /*
    bu sayfadakiler methodlar

    "Given kullanici anasayfaya gider     ]
    Then arama kurusuna Nutella yazar ve enter tusuna basar
    And arama sonuclarinin Nutella icerdigini test eder
    And sayfayi kapatir" bunlar ise method call lar

    Direkt calistirdigimizda test passed der  cunku method var ve sorunsuz calisti.
    "@Given("kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {

    }"  bu sekilde ici bosken.

    Iclerini doldurmamiz gerek

    "@Given("kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }"  boyle hepsinin icini doldurunca features e gidip uygun olan calistirilir ve test yapilmis olur
     */

    @Given("kullanici Amazon anasayfaya gider")
    public void kullanici_Amazon_anasayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }
    @Then("arama kutusuna Nutella yazar ve enter tusuna basar")
    public void arama_kutusuna_nutella_yazar_ve_enter_tusuna_basar() {

        amazonPage.searchBox.sendKeys("Nutella"+ Keys.ENTER);

    }
    @Then("arama sonuclarinin Nutella icerdigini test eder")
    public void arama_sonuclarinin_nutella_icerdigini_test_eder() {

        String expectedIcerik="Nutella";
        String actualIcerik=amazonPage.resultBoxElement.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {

        Driver.closeDriver();

    }

    @Then("arama kutusuna Java yazar ve enter tusuna basar")
    public void aramaKutusunaJavaYazarVeEnterTusunaBasar() {

        amazonPage.searchBox.sendKeys("Java"+ Keys.ENTER);

    }

    @Then("arama sonuclarinin Java icerdigini test eder")
    public void aramaSonuclarininJavaIcerdiginiTestEder() {
        String expectedIcerik="Java";
        String actualIcerik=amazonPage.resultBoxElement.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    }



    @When("arama kutusuna Apple yazar ve enter tusuna basar")
    public void aramaKutusunaAppleYazarVeEnterTusunaBasar() {
        amazonPage.searchBox.sendKeys("Apple"+ Keys.ENTER);
        
    }

    @Then("arama sonuclarinin Apple icerdigini test eder")
    public void aramaSonuclarininAppleIcerdiginiTestEder() {
        String expectedIcerik="Apple";
        String actualIcerik=amazonPage.resultBoxElement.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }

    @Then("amazonda {string} icin arama yapar")                                  //burada kodlarimiz dinamiklesir
    public void amazondaIcinAramaYapar(String istedigiKelime) {

        amazonPage.searchBox.sendKeys(istedigiKelime+ Keys.ENTER);
    }

    @And("sonuclarin {string} icerdigini test eder")                             // burada kodlarimiz dinamiklesir
    public void sonuclarinIcerdiginiTestEder(String arananKelime) {

        String actualIcerik=amazonPage.resultBoxElement.getText();
        Assert.assertTrue(actualIcerik.contains(arananKelime));

    }

    @And("{int} saniye bekler")          //direkt sayi yazinca-yani sayiyi String yazmayinca- int olarak burada olusur
                                         //sayilari otomatik parametre kabul ediyor
    public void saniyeBekler(int istenenSaniye) {
        ReusableMethods.bekle(istenenSaniye);
    }


    /*
    runner clasini olusturmadigimiz icin
    eger bir scenario da hem daha once olan adimlar hemde yeni adimlar var ise calistirisak
    baslar ve yapabildiklerini yapar onceden olmayanlarin step ine sahip degil ve calismaz
    uzerine yaklasip "create step definition" i seceriz
     */

    /*
    "Background:
    Given kullanici Amazon anasayfaya gider" ile ayni classtaki her scenario nun ortak adimi bir kere yazilmis olur
    her scenario tek basina calisir illa features sevisinde tum scenario larin calismasina gerek kalmaz
     */


    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String istenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));

    }
    @Then("{string} sayfasina gittigini test eder")
    public void sayfasina_gittigini_test_eder(String istenenUrl) {
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl=ConfigReader.getProperty(istenenUrl)+ "/";
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @When("{int}.urune gider")
    public void urune_gider(Integer istenenIndex) {
        amazonPage.istenenUrunElementi(istenenIndex).click();

    }
    @Then("urun isminin {string} icerdigini test eder")
    public void urun_isminin_icerdigini_test_eder(String arananKelime) {
        String actualUrunIsmi=amazonPage.firstProductNameElement.getText();
        Assert.assertTrue(actualUrunIsmi.contains(arananKelime));

    }




}

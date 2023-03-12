package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    configuration.properties txt dosyasi:
    javada Properties class i sayesinde dosyanin icini okuyabiliyoruz. o nedenle .properties uzantisi onemlidir
    bize dinamiklik saglar  amazonExpectedContent= Nutella  yerine Java da aratabiliriz.
    ve bunun icin tekrar bir test yazmamiza gerek kalmaz sadece configuration.properties te
    = den sonrasini degistirip test edebiliriz
    yani test datalarimizi burada hazirlar gerektiginde kullaniriz
     */



    //dosya yolu sayesinde fileInputStream ile dosyanin icine ulasabiliriz okuyabiliriz.
    // once dosya yolu bulunacak sonra icine girebiliyoruz
    //properties objesi olusturuyoruz. fis ile properties methodlarini kullanarak dosyayi okuyabiliyoruz
    static Properties properties;
    static {
        String filePath= "configuration.properties";
        try {
            FileInputStream fis= new FileInputStream(filePath);
            properties= new Properties();
            properties.load(fis);
            //configuration.properties teki tum bilgileri properties objesine yuklemis oluyoruz
        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }
    public static String getProperty(String key){

        return properties.getProperty(key);

        //burada tum bilgiler degil key olarak gonderilen bilgilerin gelinmesi saglanir String key ile.
        //amazonUrl deyince tum sayfadaki bilgiler degil sadece amazonUrl gelir
        //biz bu key i yolladigimizda methoddan once static blok calisir ve configuration.propertiese gider
        //tum bilgilere ulasir ancak method daki key sayesinde sadece istenen value yu alir ve gelir
    }
}

package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target\\parallelReport1.html",  //raporlama icin bu satiri ekledik
                "json:target\\json-reports\\parallelReport1.json",  //bu satirla da json formatinda rapor yazar
                //bu raporlari devoloper lar isteyebilir
                "junit:target\\xml-report\\paralelReport1.xml"},//bu satirla da xml formatinda rapor yazar
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@wip",
        dryRun = false


)
public class ParallelRunner1 {

}

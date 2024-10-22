package runnerPackSF;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/main/java/Feature" , glue = {"sfPagePack"} , publish=true , monochrome=true)

public class SFRunner extends AbstractTestNGCucumberTests {

}

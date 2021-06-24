package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/TrailHeadAcademy.feature",glue="steps",monochrome=true)
public class RunnerTest extends AbstractTestNGCucumberTests{

}

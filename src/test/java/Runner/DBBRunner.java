package Runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="C:\\Users\\mwisl\\git\\api_framework\\API_Framework\\src\\test\\resources\\Features",
		glue= {"Runner/DBBRunner"},
		//tag= {@adin},
//	features ="classpath:Features",
//	glue= "Steps",

	dryRun=true,
	plugin = { "pretty", "html:target/cucumber-reports.html" ,"rerun:target/rerun.txt"},
	//plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

	//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	monochrome = true
	//plugin = {"pretty","html:test-output"}
	//plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
	
	)

public class DBBRunner {

}

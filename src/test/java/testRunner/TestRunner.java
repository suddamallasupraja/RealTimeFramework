package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features//Blazedemo.feature"},
		//features= {".//Features//Pagination.feature"},
		//features= {".//Features//jdbc.feature"},
		//features= {".//Features//Desktops.feature"},
	//features= {".//Features//LoginDDT_excel.feature"},
	//features= {".//Features/"},
			//features= {".//Features//Login.feature",".//Features/.feature"},
			//features= "@target/rerun.txt",
	glue="stepDefinitions",
	plugin= {"pretty","html:reports/myreport.html","json:reports/myreport.json","rerun:target/rerun.txt"},
	dryRun=false,
	monochrome=true
	//tags="@jdbc",
	//tags="@sanity and @Regression"
			//tags="@sanity or @Regression"
			//tags="@sanity and not @Regression"
		)
public class TestRunner 
{

}

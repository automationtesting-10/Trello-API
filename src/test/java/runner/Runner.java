package runner;

import com.foundation.trello.report.GeneratorReport;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

/**
 * Runner class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"com/foundation/trello/step"},
        features = {"src/test/resources/feature/board.feature"})

public class Runner extends AbstractTestNGCucumberTests {
    /**
     * The method afterExecution executes the project and generate it report.
     */
    @AfterTest
    public void afterExecution() {
        GeneratorReport.getInstance().generateReport();
    }
}

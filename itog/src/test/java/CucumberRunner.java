import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.yandex.autotest"},
        plugin = {
            "ru.yandex.autotest.util.AllureReporter",
        }
)
public class CucumberRunner {

}

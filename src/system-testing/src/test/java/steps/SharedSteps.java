package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import support.BaseSteps;

public class SharedSteps extends BaseSteps {
    @And("^fill field \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void fillFieldWithValue(String fieldSelector, String fieldValue) throws Throwable {
        driver.sendKeys(fieldValue, fieldSelector);
    }

    @When("^user click in button \"([^\"]*)\"$")
    public void userClickInButton(String btnId) throws Throwable {
        driver.click(btnId);
    }
}

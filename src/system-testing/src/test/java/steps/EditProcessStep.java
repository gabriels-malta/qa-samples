package steps;

import cucumber.api.java.en.Given;
import support.BaseSteps;

public class EditProcessStep extends BaseSteps {

    @Given("^user click in edit button$")
    public void userClickInEditButton() {
        String cssSelector = "a.ls-btn[href$=\"/edit\"]";
        driver.click(cssSelector, "css");
    }
}

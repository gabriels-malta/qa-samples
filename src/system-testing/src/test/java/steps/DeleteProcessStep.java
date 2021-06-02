package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.BaseSteps;

public class DeleteProcessStep extends BaseSteps {
    @When("^user click in first delete button$")
    public void userClickInFirstDeleteButton() {
        String cssSelector = "a[data-method]:first-of-type";
        driver.click(cssSelector, "css");
    }

    @And("^user answer yes in the confirm box$")
    public void userAnswerYesInTheConfirmBox() {
        driver.getDriver()
                .switchTo()
                .alert()
                .accept();
    }

    @Then("^home page should reload$")
    public void homePageShouldReload() {
        // the entire page will be reloaded, there is no way to assert.
    }
}

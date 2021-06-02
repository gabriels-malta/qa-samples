package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ViewDetailProcess;
import support.BaseSteps;

public class DetailProcessStep extends BaseSteps {
    private static ViewDetailProcess viewDetailProcess = new ViewDetailProcess(driver);

    @Given("^user are in the home page$")
    public void userAreInTheHomePage() {
        viewDetailProcess.openHomePage();
    }

    @Then("^user should see the \"([^\"]*)\" equal \"([^\"]*)\"$")
    public void userShouldSeeTheEqual(String fieldSelector, String expectedValue) throws Throwable {
        String actualValue = driver.getText(fieldSelector, "css");
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Then("^user should see the message \"([^\"]*)\"$")
    public void userShouldSeeTheMessage(String expectedMessage) throws Throwable {
        Assert.assertEquals(expectedMessage, viewDetailProcess.getSuccessMessage());
    }
}

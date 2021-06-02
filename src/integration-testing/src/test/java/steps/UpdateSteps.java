package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import definition.ProcessAPI;
import org.junit.Assert;
import support.RESTSupport;

public class UpdateSteps {

    @Given("^User already has the process id previously created$")
    public void userAlreadyHasTheProcessIdPreviouslyCreated() {
        ProcessAPI.clearFields();

        Assert.assertNotNull(ProcessAPI.getProcessId());
    }

    @And("^User click on button save update$")
    public void userClickOnButtonSaveUpdate() {
        String requestUrl = ProcessAPI.getEndpoint() + ProcessAPI.getProcessId();
        RESTSupport.executePut(requestUrl, ProcessAPI.getFields());
    }

    @Then("^Response should contain \"([^\"]*)\" as field (.*) value$")
    public void responseShouldContainAsFieldValue(String responseValue, String responseKey) throws Throwable {
        String value = RESTSupport.key(responseKey).toString();
        Assert.assertEquals(responseValue, value);
    }
}

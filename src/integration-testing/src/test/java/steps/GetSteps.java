package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import definition.ProcessAPI;
import support.RESTSupport;

public class GetSteps {

    @Given("^User look for a single process$")
    public void userLookForASingleProcess() {
        ProcessAPI.clearFields();
    }

    @When("^User enter id as \"([^\"]*)\"$")
    public void userEnterIdAs(String processId) throws Throwable {
        ProcessAPI.storeProcessId(processId);
    }

    @And("^User click on search button$")
    public void userClickOnSearchButton() {
        String requestUrl = ProcessAPI.getEndpoint() + ProcessAPI.getProcessId();
        RESTSupport.executeGet(requestUrl);
    }

}

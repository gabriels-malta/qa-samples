package steps;

import cucumber.api.java.en.And;
import definition.ProcessAPI;
import support.RESTSupport;

public class CreateSteps {

    @And("^User click on save button$")
    public void userClickOnSaveButton() {
        RESTSupport.executePost(ProcessAPI.getEndpoint(), ProcessAPI.getFields());
        ProcessAPI.storeProcessId(RESTSupport.key("id").toString());
    }
}

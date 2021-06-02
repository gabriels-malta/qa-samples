package steps;

import cucumber.api.java.en.And;
import definition.ProcessAPI;
import support.RESTSupport;

public class DeleteSteps {
    @And("^User click on button delete$")
    public void userClickOnButtonDelete() {
        String requestUrl = ProcessAPI.getEndpoint() + ProcessAPI.getProcessId();
        RESTSupport.executeDelete(requestUrl);
    }
}

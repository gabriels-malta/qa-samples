package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CreateNewProcess;
import pages.ViewDetailProcess;
import support.BaseSteps;

public class NewProcessStep extends BaseSteps {

    private static CreateNewProcess createNewProcessPage = new CreateNewProcess(driver);

    @Given("^user should be in home page$")
    public void userShouldBeOnHomePage() {
        createNewProcessPage.openHomePage();
    }

    @And("^fill select field with value \"([^\"]*)\"$")
    public void fillSelectFieldWithValue(String fieldValue) throws Throwable {
        String cssSelector = "select#processo_urgente";
        Select selectField = new Select(driver.getDriver().findElement(By.cssSelector(cssSelector)));
        selectField.selectByValue(fieldValue);
    }

    @And("^fill option field with value \"([^\"]*)\"$")
    public void fillOptionFieldWithValue(String fieldValue) throws Throwable {
        driver.click("processo_arbitramento_s");
    }

    @Then("^user should see the alert  \"([^\"]*)\"$")
    public void userShouldSeeTheAlert(String expectedValue) throws Throwable {
        Assert.assertEquals(expectedValue, createNewProcessPage.getErrorMessage());
    }
}

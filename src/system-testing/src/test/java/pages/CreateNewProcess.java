package pages;

import support.DriverQA;

public class CreateNewProcess extends BasePage {

    public CreateNewProcess(DriverQA diverQA) {
        super(diverQA);
    }

    public void openHomePage(){
        driver.openURL(getUrlHomePage());
    }


    public String getErrorMessage() {
        String selector = "div>p.ls-alert-danger";
        return driver.getText(selector, "css");
    }
}

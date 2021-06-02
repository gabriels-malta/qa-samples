package pages;

import support.DriverQA;

public class ViewDetailProcess extends BasePage {
    public ViewDetailProcess(DriverQA diverQA) {
        super(diverQA);
    }

    public String getSuccessMessage() {
        String selector = "div.ls-alert-success>p";
        return driver.getText(selector, "css");
    }

    public void openHomePage() {
        driver.openURL(getUrlHomePage());
    }
}

package pages;

import support.DriverQA;

public class BasePage {
    private final String urlBase = "http://agapito-server.herokuapp.com/processos";
    protected final DriverQA driver;

    BasePage(DriverQA diverQA) {
        this.driver = diverQA;
    }

    protected String getUrlHomePage() {
        return urlBase;
    }

    protected String getUrlNewProcess() {
        return urlBase + "/new";
    }

    protected String getUrlShowDetails(String id) {
        return urlBase + "/" + id;
    }

    protected String getUrlEdit(String id) {
        return urlBase + "/" + id + "/edit";
    }
}

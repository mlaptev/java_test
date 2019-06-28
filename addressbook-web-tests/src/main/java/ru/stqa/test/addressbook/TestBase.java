package ru.stqa.test.addressbook;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();
    //private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}

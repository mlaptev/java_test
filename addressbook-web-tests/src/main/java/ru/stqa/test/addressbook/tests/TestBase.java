package ru.stqa.test.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.test.addressbook.appmanager.ApplicationManager;
import sun.plugin2.util.BrowserType;

import static org.testng.Assert.assertTrue;

public class TestBase {



    public final ApplicationManager app = new ApplicationManager(org.openqa.selenium.remote.BrowserType.CHROME);

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

    public ApplicationManager getApplicationManager() {
        return app;
    }





}

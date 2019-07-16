package ru.stqa.test.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.test.addressbook.appmanager.ApplicationManager;

import static org.testng.Assert.assertTrue;

public class TestBase {
  //  private final ApplicationManager applicationManager = new ApplicationManager();


    public final ApplicationManager app = new ApplicationManager();

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

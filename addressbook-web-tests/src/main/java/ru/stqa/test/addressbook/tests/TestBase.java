package ru.stqa.test.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.test.addressbook.appmanager.ApplicationManager;


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
}

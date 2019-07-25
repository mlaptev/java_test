package ru.stqa.test.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.test.addressbook.appmanager.ApplicationManager;


public class TestBase {



    public static final ApplicationManager app = new ApplicationManager(org.openqa.selenium.remote.BrowserType.CHROME);

//    @BeforeMethod
    @BeforeSuite
    public void setUp() throws Exception { app.init(); }

//    @AfterClass(alwaysRun = true)
    @AfterSuite
    public void tearDown() { app.stop(); }
}

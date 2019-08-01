package ru.stqa.test.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.test.addressbook.appmanager.ApplicationManager;


public class TestBase {



    public static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

//    @BeforeMethod
    @BeforeSuite
    public void setUp() throws Exception { app.init(); }

//    @AfterClass(alwaysRun = true)
    @AfterSuite
    public void tearDown() { app.stop(); }
}

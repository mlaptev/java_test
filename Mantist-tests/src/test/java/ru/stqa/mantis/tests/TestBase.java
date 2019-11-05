package ru.stqa.mantis.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;


public class TestBase {



    public static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", org.openqa.selenium.remote.BrowserType.CHROME));

//    @BeforeMethod
    @BeforeSuite
    public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak" );
    }

//    @AfterClass(alwaysRun = true)
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop(); }


}

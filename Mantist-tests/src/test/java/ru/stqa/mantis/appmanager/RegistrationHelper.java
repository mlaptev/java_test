package ru.stqa.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{


    public RegistrationHelper(ApplicationManager app) {
        super((WebDriver) app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") +"login.php");
        type(By.name("username"), username);
    }
}

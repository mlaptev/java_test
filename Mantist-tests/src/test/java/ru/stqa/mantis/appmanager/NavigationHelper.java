package ru.stqa.mantis.appmanager;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperBase {
    public NavigationHelper(ApplicationManager app) {
        super(app.getDriver());
    }

    public void manageUserPage() {
        click(By.linkText("Manage"));
        click(By.linkText("Manage Users"));
    }

}

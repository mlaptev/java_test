package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage(String groups) {
        click(By.linkText(groups));
    }

    public void gotoContactPage() {
        wd.findElement(By.linkText("home")).click();
    }
}

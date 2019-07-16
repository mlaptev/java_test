package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {


    FirefoxDriver wd;


    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void gotoGroupPage(String groups) {
        wd.findElement(By.linkText(groups)).click();
    }


    public void gotoContactPage() {
        wd.findElement(By.linkText("home")).click();
    }
}

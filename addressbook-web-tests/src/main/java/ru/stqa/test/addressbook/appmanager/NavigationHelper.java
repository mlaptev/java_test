package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {


        click(By.linkText("groups"));
    }

    public void contactPage() {
        if (isElementPresent(By.id("maintable"))) {
           return;
        }
        click(By.linkText("home"));
    }
}

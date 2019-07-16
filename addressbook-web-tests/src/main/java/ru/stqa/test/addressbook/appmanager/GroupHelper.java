package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.test.addressbook.model.GroupData;

public class GroupHelper {

    FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void submitGroupCreation(String submit) {
        wd.findElement(By.name(submit)).click();
    }

    public void fillGroupForm(GroupData groupData) {
        type(groupData);
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void type(GroupData groupData) {
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    }

    public void initGroupCreation(String s) {
        wd.findElement(By.name(s)).click();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

 //   public void gotoGroupPage(String groups) {
 //       wd.findElement(By.linkText(groups)).click();
 //   }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}

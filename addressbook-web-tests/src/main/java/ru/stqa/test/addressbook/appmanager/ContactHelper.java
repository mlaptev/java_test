package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.test.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper  extends HelperBase {
    private boolean acceptNextAlert = true;

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        click(By.name("firstname"));
        type(By.name("firstname"), contactData.getFirstname());
        click(By.name("middlename"));
        type(By.name("middlename"),contactData.getMiddlename());
        click(By.name("lastname"));
        type(By.name("lastname"), contactData.getLastname());
        click(By.name("nickname"));
        type(By.name("nickname"),contactData.getNickname());
        click(By.name("title"));
        type(By.name("title"),contactData.getTitle());
        click(By.name("company"));
        type(By.name("company"),contactData.getCompany());
        click(By.name("address"));
        type(By.name("address"),contactData.getAddress());
        click(By.name("home"));
        type(By.name("home"), contactData.getHomephone());
        click(By.name("mobile"));
        type(By.name("mobile"),contactData.getMobilephone());
        click(By.name("work"));
        type(By.name("work"), contactData.getWorkphone());
        click(By.name("fax"));
        click(By.name("fax"));
        type(By.name("fax"), contactData.getFaxphone());
        click(By.name("email"));
        type(By.name("email"), contactData.getEmailone());
        click(By.name("email2"));
        type(By.name("email2"),contactData.getEmailtwo());
        click(By.name("email3"));
        type(By.name("email3"),contactData.getEmailthree());
        click(By.name("homepage"));
        type(By.name("homepage"),contactData.getHomapage());
        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayday());
        click(By.name("bday"));
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthdaymonth());
        click(By.name("bmonth"));
        click(By.name("byear"));
        type(By.name("byear"),contactData.getBirthdayyear());
        click(By.name("aday"));
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAniday());
        click(By.name("aday"));
        click(By.name("amonth"));
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnimonth());
        click(By.name("amonth"));
        click(By.name("ayear"));
        type(By.name("ayear"),contactData.getAniyear());
        click(By.name("address2"));
        type(By.name("address2"),contactData.getSecondadresss());
        click(By.name("phone2"));
        type(By.name("phone2"),contactData.getSecondhome());
        click(By.name("notes"));
        type(By.name("notes"),contactData.getNotes());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void gotoContactPage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void deleteContact() {
        acceptNextAlert = true;
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = wd.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

    public void initContactModification() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test3@t.ru'])[1]/following::img[2]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}

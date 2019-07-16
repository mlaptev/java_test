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
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(contactData.getWorkphone());
        click(By.name("fax"));
        click(By.name("fax"));
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(contactData.getFaxphone());
        click(By.name("email"));
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmailone());
        click(By.name("email2"));
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(contactData.getEmailtwo());
        click(By.name("email3"));
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(contactData.getEmailthree());
        click(By.name("homepage"));
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(contactData.getHomapage());
        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayday());
        click(By.name("bday"));
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthdaymonth());
        click(By.name("bmonth"));
        click(By.name("byear"));
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactData.getBirthdayyear());
        click(By.name("aday"));
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAniday());
        click(By.name("aday"));
        click(By.name("amonth"));
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnimonth());
        click(By.name("amonth"));
        click(By.name("ayear"));
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(contactData.getAniyear());
        click(By.name("address2"));
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactData.getSecondadresss());
        click(By.name("phone2"));
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactData.getSecondhome());
        click(By.name("notes"));
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
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
}

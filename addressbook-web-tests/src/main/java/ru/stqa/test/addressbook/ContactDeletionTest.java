package ru.stqa.test.addressbook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.test.addressbook.TestBase;

public class ContactDeletionTest extends TestBase {
  private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();
  FirefoxDriver wd;

 //@BeforeClass(alwaysRun = true)
// public void setUp() throws Exception {
  // wd = new FirefoxDriver();
  // wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  // wd.get("http://localhost/addressbook/");
 // login("admin", "secret");
 // }

 // private void login(String username, String password) {
 // wd.findElement(By.name("user")).clear();
   //wd.findElement(By.name("user")).sendKeys(username);
  //  wd.findElement(By.name("pass")).clear();
  // wd.findElement(By.name("pass")).sendKeys(password);
  // wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
 // }

  @Test
  public void testContactDeletion() {

   wd.findElement(By.name("selected[]")).click();
   acceptNextAlert = true;
   wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
   wd.switchTo().alert().accept();
    wd.findElement(By.linkText("home")).click();
  }

 private void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }

 // @AfterClass(alwaysRun = true)
//  public void tearDown() throws Exception {
   // wd.quit();
   // String verificationErrorString = verificationErrors.toString();
  //  if (!"selected".equals(verificationErrorString)) {
//      fail(verificationErrorString);
  //  }
 // }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
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

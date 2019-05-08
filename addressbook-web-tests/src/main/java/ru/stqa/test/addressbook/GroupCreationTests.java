package ru.stqa.test.addressbook;


import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class GroupCreationTests {

  //private StringBuffer verificationErrors = new StringBuffer();
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
  }

  @Test
  public void testGroupCreation() {
    gotoGroupPage("groups");
    initGroupCreation("new");
    initGroupCreation("group_name");
    fillGroupForm(new GroupData("ttt1", "tt", "tt"));
    submitGroupCreation("submit");
    gotoGroupPage("group page");
  }

  private void submitGroupCreation(String submit) {
    wd.findElement(By.name(submit)).click();
  }

  private void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void initGroupCreation(String s) {
    wd.findElement(By.name(s)).click();
  }

  private void gotoGroupPage(String groups) {
    wd.findElement(By.linkText(groups)).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    wd.quit();
    //String verificationErrorString = verificationErrors.toString();
   // if (!"".equals(verificationErrorString)) {
    //  fail(verificationErrorString);
   // }
 // }

//  private boolean isElementPresent(By by) {
  //  try {
    //  wd.findElement(by);
      //return true;
    //} catch (NoSuchElementException e) {
     // return false;
    //}
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  //private String closeAlertAndGetItsText() {
   // try {
     // Alert alert = wd.switchTo().alert();
     // String alertText = alert.getText();
     // if (acceptNextAlert) {
      //  alert.accept();
     // } else {
     //   alert.dismiss();
     // }
     // return alertText;
   // } finally {
   //   acceptNextAlert = true;
    //}
  //}
}

package ru.stqa.test.addressbook;


import org.testng.annotations.*;
public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage("groups");
    initGroupCreation("new");
    initGroupCreation("group_name");
    fillGroupForm(new GroupData("ttt1", "tt", "tt"));
    submitGroupCreation("submit");
    gotoGroupPage("group page");
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

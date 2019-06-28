package ru.stqa.test.addressbook;


import org.testng.annotations.*;
public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage("groups");
    app.initGroupCreation("new");
    app.initGroupCreation("group_name");
    app.fillGroupForm(new GroupData("ttt1", "tt", "tt"));
    app.submitGroupCreation("submit");
    app.gotoGroupPage("group page");
  }


}

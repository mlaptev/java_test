package ru.stqa.test.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation("new");
    app.getGroupHelper().initGroupCreation("group_name");
    app.getGroupHelper().fillGroupForm(new GroupData("ttt1", "tt", "tt"));
    app.getGroupHelper().submitGroupCreation("submit");
    app.getNavigationHelper().gotoGroupPage();
  }


}

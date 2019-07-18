package ru.stqa.test.addressbook.tests;


import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().gotoGroupPage("groups");
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().gotoGroupPage("groups");
  }

}

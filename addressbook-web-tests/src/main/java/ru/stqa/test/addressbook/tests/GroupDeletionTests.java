package ru.stqa.test.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.GroupData;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("ttt1", "tt", "tt"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().gotoGroupPage();
  }

}

package ru.stqa.test.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.GroupData;

import java.util.List;


public class GroupDeletionTests extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("ttt1", "tt", "tt"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);



  }

}

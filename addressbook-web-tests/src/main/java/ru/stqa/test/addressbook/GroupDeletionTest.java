package com.example.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.TestBase;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testDeleteGroup() {
    app.gotoGroupPage("groups");
    app.selectGroup();
    app.deleteSelectedGroups();
    app.gotoGroupPage("groups");
  }

}

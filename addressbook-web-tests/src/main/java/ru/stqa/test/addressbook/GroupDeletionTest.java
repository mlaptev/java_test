package com.example.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.TestBase;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testDeleteGroup() {
    gotoGroupPage("groups");
    selectGroup();
    deleteSelectedGroups();
    gotoGroupPage("groups");
  }

}

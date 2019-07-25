package ru.stqa.test.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData().withName("test1"));
    }
  }


  @Test
  public void testDeleteGroup() {
    Groups before = app.group().all();
    GroupData deleteGroup = before.iterator().next();
    app.group().delete(deleteGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deleteGroup)));
  }
}

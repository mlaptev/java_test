package ru.stqa.test.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }


  @Test
  public void testDeleteGroup() {
    Groups before = app.group().all();
    GroupData deleteGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deleteGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.group().all();
//    assertThat(after, equalTo(before.without(deleteGroup)));

  }
}

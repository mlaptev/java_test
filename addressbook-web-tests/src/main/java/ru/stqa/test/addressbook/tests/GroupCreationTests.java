package ru.stqa.test.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
 //   Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1");
    app.group().create(group);
 //   Groups after = app.group().all();
 //   assertThat(after.size(), equalTo(before.size() + 1));



  //  assertThat(after, equalTo(
 //           before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}

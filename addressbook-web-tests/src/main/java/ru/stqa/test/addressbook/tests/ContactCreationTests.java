package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().clist();
    ContactData contact = new ContactData("first name", "middle name", "last name", "nickname",
            "title", "company", "addressss");
    app.contact().create(contact);
    app.goTo().contactPage();
    List<ContactData> after = app.contact().clist();
    Assert.assertEquals(after.size(), before.size() + 1);



//    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
 //   before.sort(byId);
 //   after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

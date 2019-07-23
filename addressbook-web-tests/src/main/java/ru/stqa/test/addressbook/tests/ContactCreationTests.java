package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData("first name", "middle name", "last name", "nickname",
            "title", "company", "addressss", "123456789", "12345678", "1234567890", "12345678901",
            "test@t.ru", "test2@t.ru", "test3@t.ru", "homapage", "6", "March",
            "1985", "6", "May", "1234", "ttt1", "adressshome", "homae", "noties");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);



    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

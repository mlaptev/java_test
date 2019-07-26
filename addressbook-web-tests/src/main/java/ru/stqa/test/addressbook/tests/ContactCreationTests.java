package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().clist();
    ContactData contact = new ContactData().withFirstname("first name").withLastname("last name"); //"middle name", "last name", "nickname",
          //  "title", "company", "addressss");
    app.goTo().contactPage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(contact, true);
    app.contact().submitContactCreation();
    app.goTo().contactPage();
    Set<ContactData> after = app.contact().clist();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}

package ru.stqa.test.addressbook.tests;

import org.hamcrest.core.IsEqual;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;


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

    assertThat(after.size(), IsEqual.equalTo(before.size() + 1));
 //   assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId().max().getAsInt())))));




    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}

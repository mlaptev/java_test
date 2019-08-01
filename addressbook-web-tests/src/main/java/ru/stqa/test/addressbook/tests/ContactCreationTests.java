package ru.stqa.test.addressbook.tests;

import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    app.goTo().contactPage();

   Contacts before = app.contact().clist();


    ContactData contact = new ContactData().withFirstname("first name").withLastname("last name").withNickname("nickname").WorkPhone("111").MobilePhone("222").HomePhone("333"); //"middle name", "last name", "nickname",
          //  "title", "company", "addressss");
    app.contact().create(contact);
   // app.contact().initContactCreation();
 //   app.contact().fillContactForm(contact, true);
 //   app.contact().submitContactCreation();
 //   app.goTo().contactPage();
    Contacts after = app.contact().clist();

    assertThat(after.size(), IsEqual.equalTo(before.size() + 1));
  //  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId().max().getAsInt())))));





    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
   // before.add(contact);
  //  Assert.assertEquals(before, after);
  }

}

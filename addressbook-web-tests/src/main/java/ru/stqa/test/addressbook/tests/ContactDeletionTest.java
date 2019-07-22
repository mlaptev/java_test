package ru.stqa.test.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;


public class ContactDeletionTest  extends TestBase {

    @Test
  public void testContactDeletion() {
      app.getNavigationHelper().gotoContactPage();
      if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData ("first name", "middle name", "last name", "nickname",
                    "title", "company", "addressss", "123456789", "12345678", "1234567890", "12345678901",
                    "test@t.ru", "test2@t.ru", "test3@t.ru", "homapage", "6", "March",
                    "1985", "6", "May", "1234", "ttt1", "adressshome", "homae", "noties"));
        }
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().gotoContactPage();
  }



}

package ru.stqa.test.addressbook;

import org.testng.annotations.*;


public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("first name", "middle name", "last name", "nickname", "title", "company", "addressss", "123456789", "12345678", "1234567890", "12345678901", "test@t.ru", "test2@t.ru", "test3@t.ru", "homapage", "6", "March", "1985", "6", "May", "1234", "adressshome", "homae", "noties"));
    app.submitContactCreation();
  }

}

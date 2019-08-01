package ru.stqa.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;

import static ru.stqa.test.addressbook.tests.TestBase.app;

public class ContactPhoneTests {
    @Test
    public void testContactPhones() {
        app.goTo().contactPage();
        ContactData contact = app.contact().clist().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}

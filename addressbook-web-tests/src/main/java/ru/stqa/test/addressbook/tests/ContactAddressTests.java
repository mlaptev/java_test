package ru.stqa.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @Test
    public void testContactAddress() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);


        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}

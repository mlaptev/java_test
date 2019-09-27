package ru.stqa.test.addressbook.tests;

import ru.stqa.test.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;




public class ContactEmailTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
        if (app.db().contacts().size() == 0) {
            ContactData contact = new ContactData().withFirstName("firstname").withLastName("lastname");
            app.contact().create(contact, true);
            //, "middle name", "last name", "nickname",
            //   "title", "company", "addressss"));
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
        assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
        assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
    }
}

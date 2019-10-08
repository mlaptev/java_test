package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionOfGroupTests extends TestBase{


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
    public void deleteFromGroupTest() {
        Contacts contacts = app.db().contacts();
        ContactData contact = new ContactData();
        for (ContactData cd : contacts) {
            if (!cd.getGroups().isEmpty()) {
                contact = cd;
                break;
            }
        }
        GroupData group = contact.getGroups().iterator().next();
        app.goTo().contactPage();
        app.contact().deleteFromGroup(contact, group);
        Groups groupsAfter = new Groups();
        for (ContactData cd : app.db().contacts()) {
            if (cd.getId() == contact.getId()) {
                groupsAfter = cd.getGroups();
                break;
            }
        }
        assertThat(groupsAfter, equalTo(contact.getGroups().without(group)));
    }
}

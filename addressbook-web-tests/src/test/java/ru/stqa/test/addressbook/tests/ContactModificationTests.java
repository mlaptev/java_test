package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("firstname").withLastName("lastname")); //, "middle name", "last name", "nickname",
            //   "title", "company", "addressss"));
        }
    }


    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("firstname")
                .withMiddleName("middlename")
                .withLastName("lastname")
                .withNickName("nickname")
                .withTitle("title")
                .withCompany("company")
                .withAddress("addressss")
                .withHomePhone("111")
                .withMobilePhone("222")
                .withWorkPhone("333")
                .withEmail1("email@mail")
                .withEmail2("email2@mail")
                .withEmail3("email3@mail");

        app.contact().modify(contact);

        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
//        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


    }
}
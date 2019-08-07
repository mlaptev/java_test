package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name")); //, "middle name", "last name", "nickname",
            //   "title", "company", "addressss"));
        }
    }


    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("first name")
                .withMiddleName("middle name")
                .withLastName("last name")
                .withNickName("nickname")
                .withTitle("title")
                .withCompany("company")
                .withAddress("addressss")
                .withHomePhone("111")
                .withMobilePhone("222")
                .withWorkPhone("333")
                .withEmailOne("1email@1mail")
                .withEmailTwo("2email@2mail")
                .withEmailTree("3email@3mail");

        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }
}
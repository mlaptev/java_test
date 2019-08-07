package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest  extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("name")
                    .withLastName("lastname")
                    .withMiddleName("midname")
                    .withTitle("title")
                    .withCompany("company")
                    .withAddress("address")
                    .withHomePhone("65434")
                    .withEmailOne("email1@mail")
                    .withEmailTwo("email2@mail")
                    .withEmailTree("email3@mail"));


        }
    }


    @Test
  public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));


  }


}

package ru.stqa.test.addressbook.tests;

import ru.stqa.test.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;




public class ContactEmailTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().contactPage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("name123")
                    .withLastName("lastname123")
                    .withMiddleName("midname123")
                    .withTitle("title123")
                    .withNickName("nick123")
                    .withCompany("company123")
                    .withAddress("address123")
                    .withHomePhone("65434")
                    .withMobilePhone("+798545375242")
                    .withWorkPhone("7984344")
                    .withEmail("asd@asdf.qwe")
                    .withEmail2("twerhh@ksdfg.vikd")
                    .withEmail3("fasdkfjlkj@sdggh.awed"));
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
//        assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
//        assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
    }
}

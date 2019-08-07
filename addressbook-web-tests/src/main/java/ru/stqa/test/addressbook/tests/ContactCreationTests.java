package ru.stqa.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.Contacts;
import ru.stqa.test.addressbook.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @Test
    public void testContactCreation() {
         app.goTo().contactPage();

       Contacts before = app.contact().all();


        ContactData contact = new ContactData().withFirstName("firstname").withLastName("lastname").withNickName("nickname").withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
        .withAddress("addressss").withEmailOne("email1@mail").withEmailTwo("email2@mail").withEmailTree("email3@mail");
        app.contact().create(contact);
       // app.contact().initContactCreation();
        //app.contact().fillContactForm(contact);
        //app.contact().submitContactCreation();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}



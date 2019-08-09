package ru.stqa.test.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.Contacts;
import ru.stqa.test.addressbook.model.ContactData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @Test
    public void testContactCreation() {
         app.goTo().contactPage();

       Contacts before = app.contact().all();


        File photo = new File("src/main/resources/Test.jpg");
        ContactData contact = new ContactData()
                .withFirstName("firstname")
                .withLastName("lastname")
                .withPhoto(photo)
                .withNickName("nickname")
                .withHomePhone("111")
                .withMobilePhone("222")
                .withWorkPhone("333")
                .withAddress("addressss")
                .withEmail1("email")
                .withEmail2("email2@mail")
                .withEmail3("email3@mail");
        app.contact().create(contact);
       // File photo = new File(("src/main/resources/Test.jpg"));
       // app.contact().initContactCreation();
        //app.contact().fillContactForm(contact);
        //app.contact().submitContactCreation();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}



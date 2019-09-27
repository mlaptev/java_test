package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTestsDb extends TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            GroupData newGroup = new GroupData().withName("firstname").withHeader("test2").withFooter("test3");
            app.group().create(newGroup);
        }
    }


    @Test
    public void testContactCreation() {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/Test.jpg");
        ContactData newContact = new ContactData().withFirstName("firstname")
                  .withLastName("lastname")
                   .withPhoto(photo)
                   .withNickName("nickname")
                   .withHomePhone("111")
                   .withPhoto(photo)
                   .inGroup(groups.iterator().next());

        app.goTo().contactPage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.goTo().contactPage();
    }


}



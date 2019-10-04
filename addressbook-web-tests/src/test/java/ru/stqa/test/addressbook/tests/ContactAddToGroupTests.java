package ru.stqa.test.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

public class ContactAddToGroupTests extends TestBase {
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
    public void testAddContactToGroup() {
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test1").withHeader("test2").withFooter("test3");
        app.group().create(group);
        Groups after = app.db().groups();
        app.goTo().contactPage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groupsBefore = contact.getGroups();
        app.contact().addToGroup(contact, group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()));
        Groups groupsAfter = new Groups();
        for (ContactData cd : app.db().contacts()) {
            if (cd.getId() == contact.getId()) {
                groupsAfter = cd.getGroups();
                break;
            }
        }
    }

}
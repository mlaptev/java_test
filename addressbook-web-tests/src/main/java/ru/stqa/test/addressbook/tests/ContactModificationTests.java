package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
        if (app.contact().clist().size() == 0) {
            app.contact().create(new ContactData("first name", "middle name", "last name", "nickname",
                    "title", "company", "addressss"));
        }
    }



    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().clist();
        int index = before.size() -1;
        ContactData contact = new ContactData("first name", "middle name", "last name", "nickname",
                "title", "company", "addressss");

        app.contact().modify(index);
        List<ContactData> after = app.contact().clist();
        Assert.assertEquals(after.size(), before.size());



        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    private void ModifyContact(int index) {
        app.contact().selectContact(index);
        app.contact().initContactModification();
        app.contact().submitContactModification();
        app.goTo().contactPage();
    }

}

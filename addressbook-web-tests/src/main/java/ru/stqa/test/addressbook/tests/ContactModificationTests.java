package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
//        if (app.contact().clist().size() == 0) {
//            app.contact().create(new ContactData().withFirstname("first name")); //, "middle name", "last name", "nickname",
                 //   "title", "company", "addressss"));
 //       }
    }



    @Test
    public void testContactModification() {

        Set<ContactData> before = app.contact().clist();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("first name").withMiddlename("middle name").withLastname("last name").withNickname("nickname").withTitle("title").withCompany("company").withAddress("addressss");

        app.contact().modify(contact);
        Set<ContactData> after = app.contact().clist();
        Assert.assertEquals(after.size(), before.size());



        before.remove(modifiedContact);
        before.add(contact);
 //       Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
        Assert.assertEquals(before, after);
    }



}

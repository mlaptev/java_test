package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
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
        if (app.contact().clist().size() == 0) {
//            app.contact().create(new ContactData().withFirstname("first name")); //, "middle name", "last name", "nickname",
                 //   "title", "company", "addressss"));
       }
    }



    @Test
    public void testContactModification() {
        Contacts before = app.contact().clist();
     //   Set<ContactData> before = app.contact().clist();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("first name")
                .withMiddlename("middle name").withLastname("last name").withNickname("nickname")
                .withTitle("title").withCompany("company").withAddress("addressss").HomePhone("111").MobilePhone("222").WorkPhone("333");

        app.contact().modify(contact);
        Contacts after = app.contact().clist();

 //       Set<ContactData> after = app.contact().clist();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


        before.remove(modifiedContact);
        before.add(contact);
 //       Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
        Assert.assertEquals(before, after);
    }



}

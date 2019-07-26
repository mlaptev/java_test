package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;


public class ContactDeletionTest  extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
 //       if (app.contact().clist().size() == 0) {
  //          app.contact().create(new ContactData().withFirstname("first name")); //, "middle name", "last name", "nickname",
  //                  //"title", "company", "addressss"));
 //       }
    }



    @Test
  public void testContactDeletion() {
      Set<ContactData> before = app.contact().clist();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().clist();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);


  }


}

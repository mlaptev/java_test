package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.GroupData;

import java.util.List;


public class ContactDeletionTest  extends TestBase {

    @Test
  public void testContactDeletion() {
      app.getNavigationHelper().gotoContactPage();
      if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData ("first name", "middle name", "last name", "nickname",
                    "title", "company", "addressss" ));
        }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size());
      app.getContactHelper().deleteContact();
      app.getContactHelper().gotoContactPage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);


  }



}

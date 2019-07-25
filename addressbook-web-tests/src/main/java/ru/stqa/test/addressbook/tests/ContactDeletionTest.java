package ru.stqa.test.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.test.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest  extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().contactPage();
        if (app.contact().clist().size() == 0) {
            app.contact().create(new ContactData("first name", "middle name", "last name", "nickname",
                    "title", "company", "addressss"));
        }
    }



    @Test
  public void testContactDeletion() {
      List<ContactData> before = app.contact().clist();
      int index = before.size() - 1;
        app.contact().delete(index);

        List<ContactData> after = app.contact().clist();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);


  }

    private void delete(int index) {
        app.contact().selectContact(index);
        app.contact().deleteContact();
        app.contact().ContactPage();
    }


}

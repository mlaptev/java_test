package ru.stqa.test.addressbook.tests;

import org.testng.annotations.*;

public class ContactDeletionTest  extends TestBase {

    @Test
  public void testContactDeletion() {
      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().gotoContactPage();
  }

}

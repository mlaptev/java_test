package ru.stqa.test.addressbook.appmanager;

import org.openqa.selenium.*;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper  extends HelperBase {
    private boolean acceptNextAlert = true;


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {

        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
//      type(By.name("fax"), contactData.getFaxphone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());
//        click(By.name("homepage"));
//        type(By.name("homepage"), contactData.getHomapage());
//        click(By.name("bday"));
//        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthdayday());
//        click(By.name("bday"));
//        click(By.name("bmonth"));
//        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthdaymonth());
//        click(By.name("bmonth"));
//        click(By.name("byear"));
//        type(By.name("byear"), contactData.getBirthdayyear());
//        click(By.name("aday"));
//        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAniday());
//        click(By.name("aday"));
//        click(By.name("amonth"));
//        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnimonth());
//        click(By.name("amonth"));
//        click(By.name("ayear"));
//        type(By.name("ayear"), contactData.getAniyear());
//        click(By.name("address2"));
//        type(By.name("address2"), contactData.getSecondadresss());
//        click(By.name("phone2"));
//        type(By.name("phone2"), contactData.getSecondhome());
//        click(By.name("notes"));
//        type(By.name("notes"), contactData.getNotes());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void goToContactCreationPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
          return;
       }
        click(By.linkText("add new"));
    }



    public void ContactPage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        wd.findElement(By.linkText("home")).click();
    }

    public void deleteContact() {
        acceptNextAlert = true;
        wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    private void editContactById(int id) {
        click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        contactCache = null;
        ContactPage();
    }


    public void modify(ContactData contact) {
        //ContactPage();
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
        ContactPage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        contactCache = null;
        ContactPage();
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }


    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value'%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
        }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


  //  public void create(ContactData contact) {
  //      initContactCreation();
   ///     fillContactForm(new ContactData("first name", "middle name", "last name", "nickname",
  //              "title", "company", "addressss"), true);
   //     submitContactCreation();
   //         }


    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();

        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
  //          String allEmails = cells.get(4).getText();
 //           String email = cells.get(4).getText();
            String [] emails = cells.get(4).getText().split(("\n"));
            String [] phones = cells.get(5).getText().split(("\n"));

            contactCache.add(new ContactData()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withHomePhone(phones[0])
                    .withMobilePhone(phones[1])
                    .withWorkPhone(phones[2])
                    .withAddress(address)
                    .withEmail(emails[0])
                    .withEmail2(emails[1])
                    .withEmail3(emails[2]));
        }
        return contactCache;
    }


    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withFirstName(firstName)
                .withLastName(lastName)
                .withHomePhone(home)
                .withMobilePhone(mobile)
                .withWorkPhone(work)
                .withAddress(address)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);

    }
}


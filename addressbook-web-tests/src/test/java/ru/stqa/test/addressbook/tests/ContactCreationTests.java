package ru.stqa.test.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import ru.stqa.test.addressbook.model.ContactData;
import ru.stqa.test.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{


    @DataProvider
      public Iterator<Object[]> validContactsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }




    @org.testng.annotations.Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) {
         app.goTo().contactPage();

       Contacts before = app.contact().all();


     //   File photo = new File("src/main/resources/Test.jpg");
      //  ContactData contact = new ContactData()
     //           .withFirstName("firstname")
      //          .withLastName("lastname")
     //           .withPhoto(photo)
     //           .withNickName("nickname")
     //           .withHomePhone("111")
     //           .withMobilePhone("222")
    //            .withWorkPhone("333")
      //          .withAddress("addressss")
    //            .withEmail1("email")
    //            .withEmail2("email2@mail")
    //            .withEmail3("email3@mail");
        app.contact().create(contact, true);
  //      File photo = new File(("src/test/resources/Test.jpg"));
       // app.contact().initContactCreation();
        //app.contact().fillContactForm(contact);
        //app.contact().submitContactCreation();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}



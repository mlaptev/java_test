package ru.stqa.test.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.test.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {



        @Parameter(names = "-c", description = "Contact count")
        public int count;

        @Parameter (names = "-f", description = "Target file")
        public String file;

        @Parameter (names = "-d", description = "Data format")
        public String format;



        public static void main (String[] args) throws IOException {
            ContactDataGenerator generator = new ContactDataGenerator();
            JCommander jCommander = new JCommander(generator);
            try {
                jCommander.parse(args);
            } catch (ParameterException ex) {
                jCommander.usage();
                return;
            }
            generator.run();

            //       int count = Integer.parseInt(args[0]);
//        File file = new File(args[1]);

        }
    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {

            System.out.println("Unrecognized format" + format);
        }

        }

        private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
            System.out.println(new File(".").getAbsolutePath());
            try (Writer writer = new FileWriter(file)) {
                for (ContactData contact : contacts) {
                    writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                            contact.getTitle(),
                            contact.getFirstName(),
                            contact.getMiddleName(),
                            contact.getLastName(),
                            contact.getNickName(),
                            contact.getHomePhone(),
                            contact.getMobilePhone(),
                            contact.getWorkPhone(),
                            contact.getAddress(),
                            contact.getEmail1(),
                            contact.getEmail2(),
                            contact.getEmail3()));
                }
            }
        }

        private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
                XStream xstream = new XStream();
                xstream.processAnnotations(ContactData.class);
                String xml = xstream.toXML(contacts);
                try (Writer writer = new FileWriter(file)) {
                    writer.write(xml);
                }
            }

         private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(contacts);
            try(Writer writer = new FileWriter(file)) {
                writer.write(json);
            }
         }




        private List<ContactData> generateContacts (int count) {
            List<ContactData> contacts = new ArrayList<ContactData>();
            for (int i = 0; i < count; i++) {
                contacts.add(new ContactData()
                        .withTitle("test" + i)
                        .withFirstName("name" + i)
                        .withMiddleName("middlename" + i)
                        .withLastName("surname" + i)
                        .withNickName("nick" + i)
                        .withHomePhone("7895412" + i)
                        .withMobilePhone("+78955424" + i)
                        .withWorkPhone("4561" + i)
                        .withAddress("address" + i)
                        .withEmail1("email1" + i + "@gmail.com")
                        .withEmail2("email2" + i + "@gmail.com")
                        .withEmail3("email3" + i + "@gmail.com"));
            }
            return contacts;
        }
}

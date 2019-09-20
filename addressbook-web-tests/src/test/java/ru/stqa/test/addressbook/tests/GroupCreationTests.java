package ru.stqa.test.addressbook.tests;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.test.addressbook.model.GroupData;
import ru.stqa.test.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupCreationTests extends TestBase {


    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }
    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
//            String[] split = line.split(";");
//            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
            }.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


  @Test (dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
//      String[] names = new String[]{"test1'", "test2", "test3"};
   //   for (String name : names) {



 //         GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
          app.goTo().groupPage();
          Groups before = app.group().all();
          app.group().create(group);
          assertThat(app.group().count(), equalTo(before.size() + 1));

          Groups after = app.group().all();
          assertThat(after, equalTo(
                  before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


  }
 //   @Test (testName = false)
 //   public void testBadGroupCreation() {
 //       app.goTo().groupPage();
 //       Groups before = app.group().all();
 //       GroupData group = new GroupData().withName("test'");
 //       app.group().create(group);
 //       assertThat(app.group().count(), equalTo(before.size()));
 //       Groups after = app.group().all();
 //       assertThat(after, equalTo(before));
//
 //   }
}



  //  @DataProvider
  //  public Iterator<Object[]> validGroups() {
  //      List<Object[]> list = new ArrayList<Object[]>();
  //      list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
  //      list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer3")});
  //      list.add(new Object[] {new GroupData().withName("test3").withHeader("header2").withFooter("footer3")});
  //      return list.iterator();
  //  }
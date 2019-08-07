package ru.stqa.test.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String company;

    private  String address;
    private  String mobilephone;
    private  String homephone;
    private  String workphone;
    private  String allPhones;
    private  String emailone;
    private  String emailtwo;
    private  String emailthree;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() { return firstname; }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getMiddleName() { return middlename; }


    public ContactData withMiddleName(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastName() { return lastname; }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getNickName() {
        return nickname;
    }

    public ContactData withNickName(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAddress() { return address;  }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobilePhone() { return mobilephone; }

    public ContactData withMobilePhone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public String getHomePhone() { return homephone; }

    public ContactData withHomePhone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public String getWorkPhone() { return workphone; }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public String getEmailOne() {
        return emailone;
    }
    public ContactData withEmailOne(String emailone) {
        this.emailone = emailone;
        return this;
    }


    public String getEmailTwo() {
        return emailtwo;
    }
    public ContactData withEmailTwo(String emailtwo) {
        this.emailtwo = emailtwo;
        return this;
    }


    public String getEmailThree() {
        return emailthree;
    }

    public ContactData withEmailTree(String emailthree) {
        this.emailthree = emailthree;
        return this;
    }


   // public String getGroup() {
    //    return group;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
 //       if (id != that.id) return false;
 //       return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname,lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}

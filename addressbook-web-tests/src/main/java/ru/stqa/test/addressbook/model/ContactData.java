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
    private  String email;
    private  String email1;
    private  String email2;
    private  String email3;
    private  String allEmails;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
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


    public String getEmail() {
        return email;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail1() {
        return email1;
    }
    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }


    public String getEmail2() {
        return email2;
    }
    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }


    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
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
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname,lastname, email);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

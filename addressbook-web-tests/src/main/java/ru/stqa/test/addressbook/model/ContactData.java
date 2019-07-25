package ru.stqa.test.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String title;
    private  String company;

    private  String address;
//    private final String mobilephone;
//    private final String homephone;
//    private final String workphone;
//    private final String faxphone;
//    private final String emailone;
//    private final String emailtwo;
//    private final String emailthree;
//    private final String homapage;
//    private final String birthdayday;
//    private final String birthdaymonth;
//    private final String birthdayyear;
//    private final String aniday;
//    private final String animonth;
//    private final String aniyear;
//    private String group;
//    private final String secondadresss;
//    private final String secondhome;
//    private final String notes;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address) {
        this.id = Integer.MAX_VALUE;

        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
//        this.mobilephone = mobilephone;
//        this.homephone = homephone;
//        this.workphone = workphone;
//        this.faxphone = faxphone;
//        this.emailone = emailone;
//        this.emailtwo = emailtwo;
//        this.emailthree = emailthree;
//        this.homapage = homapage;
//        this.birthdayday = birthdayday;
//        this.birthdaymonth = birthdaymonth;
//        this.birthdayyear = birthdayyear;
//        aniday = Aniday;
//        this.animonth = animonth;
//        this.aniyear = aniyear;
//        this.group = group;
//        this.secondadresss = secondadresss;
//        this.secondhome = secondhome;
//        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

//    public String getMobilephone() {
//        return mobilephone;
//    }

//    public String getHomephone() {
//        return homephone;
//    }

//    public String getWorkphone() {
//        return workphone;
//    }
//
//    public String getFaxphone() {
//        return faxphone;
//    }
//
//    public String getEmailone() {
//        return emailone;
//    }

//    public String getEmailtwo() {
//        return emailtwo;
//    }

//    public String getEmailthree() {
//        return emailthree;
//    }
//
//    public String getHomapage() {
//        return homapage;
//    }

//    public String getBirthdayday() {
//        return birthdayday;
//    }
//
//    public String getBirthdaymonth() {
//        return birthdaymonth;
//    }

//    public String getBirthdayyear() {
//        return birthdayyear;
//    }

//    public String getAniday() {
//        return aniday;
//    }

//    public String getAnimonth() {
//        return animonth;
//    }

//    public String getAniyear() {
//        return aniyear;
//    }

//    public String getSecondadresss() {
//        return secondadresss;
//    }

//    public String getSecondhome() {
//        return secondhome;
//    }

//    public String getNotes() {
//        return notes;
//    }

   // public String getGroup() {
    //    return group;


    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        //if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;


    }

}

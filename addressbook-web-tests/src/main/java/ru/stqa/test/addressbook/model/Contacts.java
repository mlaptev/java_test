package ru.stqa.test.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

        private Set<ContactData> delegate;

        public Contacts(ru.stqa.test.addressbook.model.Contacts contacts) {
            this.delegate = new HashSet<ContactData>(contacts.delegate);

        }

        public Contacts() {
            this.delegate = new HashSet<ContactData>();
        }

        @Override
        protected Set<ContactData> delegate() {
            return null;
        }

        public ru.stqa.test.addressbook.model.Contacts withAdded (ContactData contact) {
            ru.stqa.test.addressbook.model.Contacts contacts = new ru.stqa.test.addressbook.model.Contacts(this);
            contacts.add(contact);
            return contacts;

        }

        public ru.stqa.test.addressbook.model.Contacts without (ContactData contact) {
            ru.stqa.test.addressbook.model.Contacts contacts = new ru.stqa.test.addressbook.model.Contacts(this);
            contacts.add(contact);
            return contacts;

        }
    }


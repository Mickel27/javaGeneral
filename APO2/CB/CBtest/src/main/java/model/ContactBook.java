package model;

import java.util.List;
import java.util.ArrayList;

public class ContactBook {
    private ArrayList<Contact> contacts;
    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public boolean addContact(String name, String email, String phone) {
        return contacts.add(new Contact(name, email, phone));
    }

    public Contact search(String email){
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                return contact;
            }
        }
        return null;
    }
}

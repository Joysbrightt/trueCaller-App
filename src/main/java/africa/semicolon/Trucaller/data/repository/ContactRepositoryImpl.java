package africa.semicolon.Trucaller.data.repository;

import africa.semicolon.Trucaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoryImpl implements ContactRepository {
    List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size()+1);
        contacts.add(contact);
        return contact;
    }


    @Override
    public Contact findById(int id) {
        return contacts.get(id-1);
    }

    @Override
    public void deleteById(int id) {
        contacts.remove(id);
    }

    @Override
    public Contact findByLastName(String lastName) {
        for (Contact contact: contacts)
        { if (Objects.equals(lastName, contact.getLastName()))
            return  contact;}
        {
            throw  new IllegalArgumentException("Name not found, try the correct name");
        }
    }

    @Override
    public int count() {

        return contacts.size();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (Contact contact:
             contacts) {
            if (Objects.equals(firstName, contact.getFirstName()))
                return contact;
        }
        throw new IllegalArgumentException("Name not found, try the correct name");
    }















}

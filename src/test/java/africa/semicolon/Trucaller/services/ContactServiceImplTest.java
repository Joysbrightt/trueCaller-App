package africa.semicolon.Trucaller.services;

import africa.semicolon.Trucaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    ContactService contactService = new ContactServiceImpl();

    @Test
    void testThatContactCanBeAdded(){
        Contact contact = new Contact();
        contact.setFirstName("Tolu");
        contact.setLastName("Johnson");
        contact.setPhoneNumber("09087654321");

        Contact savedContact = contactService.addContact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
        Contact savedContact2 = contactService.addContact("Tomisin", "Olounje", "Bigboy");
        Contact savedContact3 = contactService.addContact("Tomisin", "Olounje", "Bigboy");

        assertEquals(contactService.getRepository().count(), 3);
        assertEquals(contact.getFirstName(), savedContact.getFirstName());
        assertEquals(savedContact3.getId(), 3);
    }

    @Test
    void testThatContactCanBeFound(){
        Contact savedContact2 = contactService.addContact("Tomisin", "Olounje", "Bigboy");
        assertEquals(contactService.getRepository().count(), 1);
        contactService.findById(1);
        assertEquals(savedContact2.getId(), 1);
    }

    @Test
    void testThatContactCanBeDeleted(){
        Contact savedContact2 = contactService.addContact("Tomisin", "Olounje", "Bigboy");
        assertEquals(contactService.getRepository().count(), 1);
        contactService.findById(1);
        String message =contactService.deleteContactById(1);
        assertEquals(message, "This contact has been deleted");
//        assertEquals(contactService.getRepository().count(), 0);

    }

    @Test
    void testThatContactCanBeUpdated(){
        Contact savedContact = contactService.addContact("Tomisin", "Olounje", "Bigboy");
        assertEquals(contactService.getRepository().count(), 1);
        contactService.findById(1);
        Contact updatedContact = contactService.updateContact("Apostle","oluwadamilola", "123434534", 1);
    assertEquals(updatedContact.getFirstName(), savedContact.getFirstName());
    assertEquals(updatedContact.getLastName(), savedContact.getLastName());
    assertEquals(updatedContact.getPhoneNumber(), savedContact.getPhoneNumber());
    }


}
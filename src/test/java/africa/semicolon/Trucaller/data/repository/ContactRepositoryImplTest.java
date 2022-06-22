package africa.semicolon.Trucaller.data.repository;

import africa.semicolon.Trucaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
private ContactRepository contactRepository;
    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test public void saveContact_countIsOneTest(){
        Contact contact =  new Contact();
        contact.setFirstName("Samson");

        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test public void saveContact_countIsTwoTest(){
        Contact contact =  new Contact();
        contact.setFirstName("Samson");
    Contact contact1 = new Contact();
    contact1.setFirstName("Ladi");
        Contact savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
        Contact savedContact2 = contactRepository.save(contact);
        assertEquals(2, savedContact.getId());
        assertEquals(2, contactRepository.count());
    }

    @Test public void saveContact_findByReturnsContactTest(){
        Contact contact =  new Contact();
        contact.setFirstName("Samson");

        Contact contact1 = new Contact();
        contact1.setFirstName("Abiola");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact1 = contactRepository.save(contact1);

        Contact foundContact = contactRepository.findById(1);
        Contact foundContact1 = contactRepository.findById(2);


        assertEquals(1, foundContact.getId());
        assertEquals(2, foundContact1.getId());
        assertEquals("Samson", foundContact.getFirstName());
        assertEquals("Abiola", foundContact1.getFirstName());

    }
    @Test public void saveContact_findByFirstNameTest(){
        Contact contact =  new Contact();
        contact.setFirstName("Tomisin");

        Contact savedContact = contactRepository.save(contact);
        Contact foundContact = contactRepository.findById(1);
        savedContact = contactRepository.findByFirstName("Tomisin");

        assertEquals(1, foundContact.getId());
        assertEquals("Tomisin", foundContact.getFirstName());

    }

}

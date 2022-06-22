package africa.semicolon.Trucaller.services;

import africa.semicolon.Trucaller.data.models.Contact;
import africa.semicolon.Trucaller.data.repository.ContactRepository;
import africa.semicolon.Trucaller.data.repository.ContactRepositoryImpl;

public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository = new ContactRepositoryImpl();
    @Override
    public Contact addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

//    @Override
//    public Contact saveContact(AddContactRequest request) {
//        Contact contact = new Contact();
//        contact.setFirstName(request.getFirstName());
//        contact.setLastName(request.getLastName())
//
//        return null;
//    }

    @Override
    public Contact findById(int id) {
        Contact foundContact = contactRepository.findById(id);
        if(foundContact.getId() == id){
            return foundContact;
        }
        else throw new IllegalArgumentException("Contact does not exist");
    }

    private Contact findByIdInternal(int id){
        Contact foundContact = contactRepository.findById(id);
        if(foundContact.getId() == id){
            return foundContact;
        }
        else throw new IllegalArgumentException("Contact does not exist");
    }

    @Override
    public String deleteContactById(int id) {
//        findByIdInternal(id);
        Contact foundContact = contactRepository.findById(id);
        if(foundContact.getId() == id){
            contactRepository.deleteById(id-1);
            return "This contact has been deleted";
        }
        else throw new IllegalArgumentException("Contact does not exist");
    }

    @Override
    public Contact updateContact(String firstName, String lastName, String phoneNumber, int id) {
        Contact contact = contactRepository.findById(id);
        if (id == contact.getId()) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhoneNumber(phoneNumber);

        }
        contactRepository.save(contact);
        return contact;
    }

}

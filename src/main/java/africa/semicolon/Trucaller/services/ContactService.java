package africa.semicolon.Trucaller.services;

import africa.semicolon.Trucaller.data.models.Contact;
import africa.semicolon.Trucaller.data.repository.ContactRepository;

public interface ContactService {
   Contact addContact(String firstName, String lastName, String phoneNumber);

   ContactRepository getRepository();

 //  Contact saveContact(AddContactRequest request);
    Contact findById(int id);

    String deleteContactById(int id);

   Contact updateContact(String firstName, String lastName, String phoneNumber, int id);
}



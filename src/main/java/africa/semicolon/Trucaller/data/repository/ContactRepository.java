package africa.semicolon.Trucaller.data.repository;

import africa.semicolon.Trucaller.data.models.Contact;

public interface ContactRepository {

    Contact save(Contact contact);
    int count();
    Contact findByFirstName(String firstName);
    Contact findById(int id);

    void deleteById(int id);

    Contact findByLastName(String lastName);
}

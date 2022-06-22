package africa.semicolon.Trucaller.services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}

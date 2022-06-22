package africa.semicolon.Trucaller.data.models;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}

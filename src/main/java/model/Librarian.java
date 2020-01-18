package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Librarian {

    private int id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Date employmentDate;
}

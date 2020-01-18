package model;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String nationalCode;
    private Timestamp creation;
    private int delayCount = 0;
    private boolean status = true;

    public User(String name, String username, String password, String nationalCode, Timestamp creation) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.creation = creation;
    }
}

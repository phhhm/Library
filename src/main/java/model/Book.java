package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    private Integer id;
    private String title;
    private String subject;
    private Long price;
    private Long penalty;
    private boolean status;

    public Book(String title, String subject, Long price, Long penalty) {
        this.title = title;
        this.subject = subject;
        this.price = price;
        this.penalty = penalty;
        status = true;
    }
}

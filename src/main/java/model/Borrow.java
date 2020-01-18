package model;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Borrow {

    public Integer id;
    public Integer user_id;
    public Integer book_id;
    public Timestamp start;
    public Timestamp end;

    public Borrow(Integer user_id, Integer book_id, Timestamp end){
        this.user_id = user_id;
        this.book_id = book_id;
        start = new Timestamp(System.currentTimeMillis());
        this.end = end;
    }

    public Borrow(Integer user_id, Integer book_id,Timestamp start, Timestamp end){
        this.user_id = user_id;
        this.book_id = book_id;
        this.start = start;
        this.end = end;
    }
}

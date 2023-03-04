package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Book extends Item {

    private String author;
    private String isbn;
}

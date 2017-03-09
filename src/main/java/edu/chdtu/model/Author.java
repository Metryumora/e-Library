package edu.chdtu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Metr_yumora on 23.11.2016.
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();


    public Set<Book> getBooks() {
        return books;
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String toString() {
        return getName() + " " + getSurname();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Author() {
    }
}

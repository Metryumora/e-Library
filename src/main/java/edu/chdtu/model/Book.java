package edu.chdtu.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by Metr_yumora on 23.11.2016.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer yearOfPublishing;

    @Column(unique = true)
    private String url;

    @Column(insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TIMESTAMP)
    @Generated(value = "GenerationTime.INSERT")
    private Date uploadTimestamp;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();


    public Set<Author> getAuthors() {
        return authors;
    }

    public Book(String name, String url, int yearOfPublishing) {
        this.name = name;
        this.url = url;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getStringAuthors() {
        String result = "";
        for (Author author :
                authors) {
            result += author.toString() + ", ";
        }
        if (result != "")
            result = result.substring(0, result.length() - 2);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Integer yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(Date uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }


    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book() {
    }
}



package edu.chdtu.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Supreme on 10.12.2016.
 */
@Entity(name = "this_year_popular")
@Immutable
public class ThisYearPopular {

    @Id
    @Column(name = "Id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "Book")
    private String bookName;

    @Column(name = "Downloads")
    private Integer downloads;

    public String getBookName() {
        return bookName;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Integer getId() {
        return id;
    }
}

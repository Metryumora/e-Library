package edu.chdtu.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by Metr_yumora on 23.11.2016.
 */
@Entity
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column()
    private Boolean active;

    @Column(insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @Temporal(TIMESTAMP)
    @Generated(value = "GenerationTime.INSERT")
    private Date downloadTimestamp;

    public Download(User user, Book book) {
        this.user = user;
        this.book = book;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDownloadTimestamp() {
        return downloadTimestamp;
    }

    public void setDownloadTimestamp(Date downloadTimestamp) {
        this.downloadTimestamp = downloadTimestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Download() {
    }

    public Download(Book book) {
        this.book = book;
    }
}

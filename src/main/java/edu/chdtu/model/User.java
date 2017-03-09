package edu.chdtu.model;

import edu.chdtu.security.PasswordStorage;

import javax.persistence.*;

/**
 * Created by Metr_yumora on 23.11.2016.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true)
    private String login;

    @Column
    private String hash;

    @Column(unique = true)
    private String email;


    public User(String name, String login, char[] password, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        try {
            this.hash = PasswordStorage.createHash(password);
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        }
    }

    public Boolean verifyPassword(char[] password) {
        try {
            return edu.chdtu.security.PasswordStorage.verifyPassword(password, this.getHash());
        } catch (PasswordStorage.CannotPerformOperationException e) {
            e.printStackTrace();
        } catch (PasswordStorage.InvalidHashException hashE) {
            hashE.printStackTrace();
        }
        return false;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public User() {
    }
}

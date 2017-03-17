package com.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User domain.
 * <p>
 * Created by freecloud on 13/03/2017.
 */

public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private Date createdDate;

    public User() {
    }

    public User(String username, String password, Date createdDate) {
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

package com.football.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class User {

    @Id
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;


    private String firstname;

    private String lastname;


    @NotEmpty
    @Size(min=4)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")
    })
    private List<Role> roles;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE", joinColumns = {
            @JoinColumn(name="USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns = {
            @JoinColumn(name="ROLE_NAME", referencedColumnName = "name")
    })
    private List<Role> roles;*/

    public User() {
    }

    public User(String email, String firstname, String lastname, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}

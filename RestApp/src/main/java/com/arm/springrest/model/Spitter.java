package com.arm.springrest.model;

import com.arm.springrest.util.SpitterRoleEnum;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name="SPITTER")
public class Spitter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="spitter_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long spitter_id;

    @Column(name="username")
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @Column(name="password")
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @Column(name="firstname")
    @NotNull
    @Size(min=2, max=30, message="{firstname.size}")
    private String firstname;

    @Column(name="lastname")
    @NotNull
    @Size(min=2, max=30, message="{lastname.size}")
    private String lastname;

    @Column(name="email")
    @NotNull
    @Size(min=2, max=30, message="{email.valid}")
    @Email(message="{email.valid}")
    private String email;

    @Column(name="insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar insert_date;

    @Column(name="last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar last_update;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="spitter_picture")
    private File spitter_picture;

    @Enumerated(EnumType.STRING)
    @Column(name="role_user")
    private SpitterRoleEnum role_user;

    public Spitter(String username,String password,String firstName,String lastName)
    {
        this.spitter_id=null;
        this.username=username;
        this.password=password;
        this.firstname=firstName;
        this.lastname=lastName;
        this.email=null;
        this.insert_date=Calendar.getInstance();
        this.last_update=Calendar.getInstance();
        this.enabled=true;
        this.spitter_picture=null;
        this.role_user=SpitterRoleEnum.SPITTER;
    }

    public Spitter(Long id, String username,String password,String firstName,String lastName)
    {
        this.spitter_id=id;
        this.username=username;
        this.password=password;
        this.firstname=firstName;
        this.lastname=lastName;
        this.email=null;
        this.insert_date=Calendar.getInstance();
        this.last_update=Calendar.getInstance();
        this.enabled=true;
        this.spitter_picture=null;
        this.role_user=SpitterRoleEnum.SPITTER;
    }

    public Spitter(){}

    public Long getSpitter_id() {
        return spitter_id;
    }

    public void setSpitter_id(Long spitter_id) {
        this.spitter_id = spitter_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Calendar insert_date) {
        this.insert_date = insert_date;
    }

    public Calendar getLast_update() {
        return last_update;
    }

    public void setLast_update(Calendar last_update) {
        this.last_update = last_update;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public File getSpitter_picture() {
        return spitter_picture;
    }

    public void setSpitter_picture(File spitter_picture) {
        this.spitter_picture = spitter_picture;
    }

    public SpitterRoleEnum getRole_user() {
        return role_user;
    }

    public void setRole_user(SpitterRoleEnum role_user) {
        this.role_user = role_user;
    }
}

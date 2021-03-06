package com.yalcin.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})})
public class User {

    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 100)
    private Integer id;

    @Size(min = 3, max = 50)
    @Column(name = "username")
    private String username;

    @Column(name = "enabled")
    private boolean enabled;

    @Email
    @Column(name = "email")
    @NotBlank
    private String email;

    @Size(min = 6, max = 20)
    @Column(name = "password")
    private String password;

    @Size(min = 3, max = 25)
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    @Size(min = 3, max = 25)
    private String lastname;

    @Column(name = "age")
    @Size(min = 1, max = 3)
    private String age;

    @Size(min = 10, max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<ActiveSessions> activeSessions = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Adress> adress = new HashSet<>();

    public User() {

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void addActiveSession(ActiveSessions activeSession){
        activeSessions.add(activeSession);
    }

    public Set<ActiveSessions> getActiveSessions(){
        return this.activeSessions;
    }

    public void setActiveSessions(Set<ActiveSessions> activeSessions){
        this.activeSessions = activeSessions;
    }

    public Set<Adress> getAdress() {
        return adress;
    }

    public void setAdress(Set<Adress> adress) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roles=" + roles +
                '}';
    }
}

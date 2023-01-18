package com.example.CRUD.entities;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="name", nullable=false)
    private String name;

    @Column(name ="surname", nullable=false)
    private String surname;

    @Column(name="email",nullable=false, length=50 , unique = true)
    private String email;

    @Column(name ="cellphone", nullable=false, unique = true)
    private String cellPhone;


    public Contact(String name, String surname, String email, String cellPhone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public Contact() {
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}

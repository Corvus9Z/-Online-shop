package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="Clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",unique = true,nullable = false)
    private Integer clientsID;

    @Column(name="Last Name",nullable = false)
    private String lastName;
    @Column(name="First Name",nullable = false)
    private String firstName;
    @Column(name = "Gender", nullable = false)
    private String gender;
    @Column(name = "E-mail", unique = true, nullable = false)
    private String eMail;
    @Column(name = "Password", unique = true, nullable = false,length = 255)
    private String password;
    @OneToOne
    DataCard dataCard;
    @OneToOne
    Credit credit;
    @OneToMany
    List<Products> productsPrice;

    public List<Products> getProductsPrice() {
        return productsPrice;
    }

    public void setProductsPrice(List<Products> productsPrice) {
        this.productsPrice = productsPrice;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public DataCard getDataCard() {
        return dataCard;
    }

    public void setDataCard(DataCard dataCard) {
        this.dataCard = dataCard;
    }

    public Integer getClientsID() {
        return clientsID;
    }

    public void setClientsID(Integer clientsID) {
        this.clientsID = clientsID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientsID=" + clientsID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password=" + password +
                '}';
    }
}

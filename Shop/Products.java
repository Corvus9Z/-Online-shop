package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",unique = true,nullable = false)
    private Integer productsID;

    @Column(name="Name",unique = true,nullable = false)
    private String name;

    @Column(name="Category",unique = true,nullable = false)
    private String category;

    @Column(name="Price",nullable = false)
    private Double price;

    @Column(name="Size",unique = true,nullable = false)
    private String size;

    @Column(name="Information",unique = true,nullable = false)
    private String information;

    @Column(name="Availability",nullable = false)
    private boolean availability;
    @Column(name="Colour",nullable = false)
    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @OneToMany
    List<Clients> clients;
     @OneToOne
    Brand brand;
     @OneToMany
    List<ReviewWithStar> reviewWithStars;

    public Integer getProductsID() {
        return productsID;
    }

    public void setProductsID(Integer productsID) {
        this.productsID = productsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<ReviewWithStar> getReviewWithStars() {
        return reviewWithStars;
    }

    public void setReviewWithStars(List<ReviewWithStar> reviewWithStars) {
        this.reviewWithStars = reviewWithStars;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productsID=" + productsID +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", information='" + information + '\'' +
                ", availability=" + availability +
                ", colour='" + colour + '\'' +
                ", clients=" + clients +
                ", brand=" + brand +
                ", reviewWithStars=" + reviewWithStars +
                '}';
    }
}

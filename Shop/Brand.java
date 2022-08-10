package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

@Entity
@Table(name="Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer brandID;

    @Column(name = "BrandName", nullable = false)
    private String brandName;

    @Column(name="Ranking",nullable = false)
    private Integer rank;

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandID=" + brandID +
                ", brandName='" + brandName + '\'' +
                ", rank=" + rank +
                '}';
    }
}

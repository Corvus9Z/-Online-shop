package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

@Entity
@Table(name="Credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",unique = true,nullable = true)
    private Integer creditID;

    @Column(name="CreditAmount",unique = true,nullable = true)
    private Double creditAmount;

    public Integer getCreditID() {
        return creditID;
    }

    public void setCreditID(Integer creditID) {
        this.creditID = creditID;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditID=" + creditID +
                ", creditAmount=" + creditAmount +
                '}';
    }
}

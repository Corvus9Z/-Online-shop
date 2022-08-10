package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import jakarta.persistence.*;

@Entity
@Table(name="DataCardTable")
public class DataCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID",unique = true,nullable = false)
    private Integer dataCardID;
    @Column(name="CardHolderName",unique = true,nullable = false)
    private String cardHolderName;
    @Column(name="CardCode",unique = true,nullable = false)
    private Integer cardCode;
    @Column(name="CVV",unique = true,nullable = false)
    private Integer cvv;
    @Column(name="ExpDate",unique = true,nullable = false)
    private Integer expDate;


    public Integer getDataCardID() {
        return dataCardID;
    }

    public void setDataCardID(Integer dataCardID) {
        this.dataCardID = dataCardID;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Integer getCardCode() {
        return cardCode;
    }

    public void setCardCode(Integer cardCode) {
        this.cardCode = cardCode;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getExpDate() {
        return expDate;
    }

    public void setExpDate(Integer expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "DataCard{" +
                "dataCardID=" + dataCardID +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardCode=" + cardCode +
                ", cvv=" + cvv +
                ", expDate=" + expDate +
                '}';
    }
}

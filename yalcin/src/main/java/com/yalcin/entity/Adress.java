package com.yalcin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_adress", schema = "public")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties(value = {"id","enabled","username","name","lastname","phoneNumber","age","activeSessions","email","password","roles"})
    private User user;

    @Size(min = 4, max = 20)
    @Column(name = "country")
    private String country;

    @Size(min = 4, max = 20)
    @Column(name = "province")
    private String province;

    @Size(min = 4, max = 20)
    @Column(name = "district")
    private String district;

    @Size(min = 4, max = 20)
    @Column(name = "street")
    private String street;

    @Size(min = 4, max = 20)
    @Column(name = "building_number")
    private String buildingNumber;

    @Size(min = 4, max = 20)
    @Column(name = "adress_type")
    private String adressType;

    public Adress() {}

    public Adress(
            String country,
            String province,
            String district,
            String street,
            String buildingNumber,
            String adressType) {
        this.country = country;
        this.province = province;
        this.district = district;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.adressType = adressType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getbuildingNumber() {
        return buildingNumber;
    }

    public void setbuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getAdressType() {
        return adressType;
    }

    public void setAdressType(String adressType) {
        this.adressType = adressType;
    }
}

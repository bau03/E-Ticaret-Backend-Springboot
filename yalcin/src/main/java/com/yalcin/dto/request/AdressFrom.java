package com.yalcin.dto.request;

import javax.persistence.Column;

public class AdressFrom {
    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name="district")
    private String district;

    @Column(name="street")
    private String street;

    @Column(name="building_number")
    private String buildingNumber;

    @Column(name="adress_type")
    private String adressType;

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

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getAdressType() {
        return adressType;
    }

    public void setAdressType(String adressType) {
        this.adressType = adressType;
    }
}

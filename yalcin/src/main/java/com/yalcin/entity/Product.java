package com.yalcin.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product", schema ="public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "product_name")
    private String productName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "showcase_enabled")
    private boolean showcaseEnabled;

    @Size(min=15,max=250)
    @Column(name="explanation")
    @NotNull
    private  String explanation;

    @Column(name="product_image")
    @Lob
    private  String productImage;

    @Column(name="file_product_image")
    private File fileProductImage;


    @Size(min = 1, max = 50)
    @Column(name = "price")
    private float price;

    @Size(min=1,max=250)
    @Column(name="stock")
    @NotNull
    private  Integer stock;

    private Date timestap;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorys = new HashSet<Category>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties(value = {"enabled","activeSessions","password","roles"})
    private User user;

    public Product(@Size(min = 3, max = 50) @NotNull String productName, @Size(min = 15, max = 250) @NotNull String explanation, @Size(min = 1, max = 50) float price, @Size(min = 1, max = 250) @NotNull Integer stock) {
        this.productName = productName;
        this.explanation = explanation;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getTimestap() {
        return timestap;
    }

    public void setTimestap(Date timestap) {
        this.timestap = timestap;
    }

    public Set<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isShowcaseEnabled() {
        return showcaseEnabled;
    }

    public void setShowcaseEnabled(boolean showcaseEnabled) {
        this.showcaseEnabled = showcaseEnabled;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public File getFileProductImage() {
        return fileProductImage;
    }

    public void setFileProductImage(File fileProductImage) {
        this.fileProductImage = fileProductImage;
    }

}

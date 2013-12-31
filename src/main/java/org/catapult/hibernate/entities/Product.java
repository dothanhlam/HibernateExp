package org.catapult.hibernate.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by LDo on 12/27/13.
 */
@Entity
@Table(name="Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="ProductID")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Description")
    private String description;

    @Column(name="Category")
    private String category;

    @Column(name="Price", columnDefinition="decimal", precision=5, scale=2)
    private BigDecimal price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

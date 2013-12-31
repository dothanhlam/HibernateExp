package org.catapult.hibernate.entities;

/**
 * Created by LDo on 12/27/13.
 */
public class CartLine {
    private Product product;
    private int quantity;

    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int val) {
        quantity += val;
    }
}

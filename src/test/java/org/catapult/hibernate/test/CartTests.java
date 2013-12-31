package org.catapult.hibernate.test;

import junit.framework.Assert;
import org.catapult.hibernate.entities.Cart;
import org.catapult.hibernate.entities.CartLine;
import org.catapult.hibernate.entities.Product;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by LDo on 12/27/13.
 */
public class CartTests {

    @Test
    public void canAddNewLines() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("P1");
        p1.setCategory("Cat1");
        p1.setPrice(new BigDecimal(1000));

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("P2");
        p2.setCategory("Cat2");
        p2.setPrice(new BigDecimal(1000));

        Cart cart = new Cart();
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);

        Assert.assertTrue(cart.getLines().toArray().length > 0);
        Assert.assertEquals(cart.getLines().toArray().length, 2);
    }

    @Test
    public void canRemoveLine() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("P1");
        p1.setCategory("Cat1");
        p1.setPrice(new BigDecimal(1000));

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("P2");
        p2.setCategory("Cat2");
        p2.setPrice(new BigDecimal(1000));

        Cart cart = new Cart();
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);
        Assert.assertEquals(cart.getLines().toArray().length, 2);

        cart.removeLine(p1);
        Assert.assertEquals(cart.getLines().toArray().length, 1);
        CartLine line = (CartLine)cart.getLines().toArray()[0];
        Assert.assertEquals(line.getProduct().getName(), "P2");
    }

    @Test
    public void calculateCartTotal() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setCategory("Cat1");
        p1.setName("P1");
        p1.setPrice(new BigDecimal(150));


        Product p2 = new Product();
        p2.setId(2);
        p2.setCategory("Cat2");
        p2.setName("P2");
        p2.setPrice(new BigDecimal(100));

        Cart cart = new Cart();
        cart.addItem(p1, 1);
        cart.addItem(p1, 2);
        cart.addItem(p2, 1);

        BigDecimal result = cart.computeTotalValue();
        Assert.assertEquals(result, new BigDecimal(550));
    }

    @Test
    public void canClearAllContent() {
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("P1");
        p1.setCategory("Cat1");
        p1.setPrice(new BigDecimal(1000));

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("P2");
        p2.setCategory("Cat2");
        p2.setPrice(new BigDecimal(1000));

        Cart cart = new Cart();
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);
        Assert.assertEquals(cart.getLines().toArray().length, 2);

        cart.clear();
        Assert.assertEquals(cart.getLines().toArray().length, 0);
    }
}

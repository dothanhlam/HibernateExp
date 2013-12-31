package org.catapult.hibernate.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by LDo on 12/27/13.
 */
public class Cart {
    private ArrayList<CartLine> lineCollection;

    public Cart() {
        lineCollection = new ArrayList<CartLine>();
    }

    public ArrayList<CartLine> getLines() {
        return this.lineCollection;
    }

    public void addItem(Product product, int quantity) {
        CartLine line = null;
        for(CartLine lineItem : lineCollection) {
            if (lineItem.getProduct().getId() == product.getId()) {
                line = lineItem;
                break;
            }
        }

        if (null == line) {
            lineCollection.add(new CartLine(product, quantity));
        }
        else {
            line.increaseQuantity(quantity);
        }
    }

    public void removeLine(Product product) {
        for (CartLine line:lineCollection) {
            if (line.getProduct().getId() == product.getId()) {
                lineCollection.remove(line);
            }
        }
    }

    public BigDecimal computeTotalValue() {
        BigDecimal sum = new BigDecimal(0);
        for (CartLine line:lineCollection) {
            BigDecimal quantity = new BigDecimal(line.getQuantity());
            BigDecimal amount = line.getProduct().getPrice().multiply(quantity);
            sum = sum.add(amount);
        }

        return sum;

    }

    public void clear() {
        lineCollection.clear();
    }
}

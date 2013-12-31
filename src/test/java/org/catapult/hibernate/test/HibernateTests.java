package org.catapult.hibernate.test;

import junit.framework.Assert;
import org.catapult.hibernate.entities.Product;
import org.catapult.hibernate.helper.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by LDo on 12/27/13.
 */
public class HibernateTests {
    private SessionFactory sf;

    @Before
    public void beforeTest() {
        sf = HibernateUtil.getSessionFactory();
    }

    @After
    public void afterTest() {
        if (null != sf) {
            sf.close();
        }
    }

    @Test
    public void queryShouldHaveAvailableItems() {
        Session session = sf.openSession();
        List<Product> products = (List<Product>) session.createQuery("from Product").list();
        Assert.assertTrue("Query should have available items", products.toArray().length > 0);
    }

    @Test
    public void orderByCategoryShouldHaveTheFirstItemIsChess() {
        Session session = sf.openSession();
        List<Product> products = (List<Product>) session.createQuery("from Product order by Category").list();
        Object[] results = products.toArray();
        Product p = (Product)results[0];
        Assert.assertEquals(p.getCategory(), "Chess");
    }
}

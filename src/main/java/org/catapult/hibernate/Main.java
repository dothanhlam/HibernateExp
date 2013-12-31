package org.catapult.hibernate;

import org.catapult.hibernate.entities.Product;
import org.catapult.hibernate.helper.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by LDo on 12/27/13.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        List<Product> products = (List<Product>) session.createQuery("from Product").list();

        System.out.print("p = " + products.toArray().length);
        session.close();
    }
}

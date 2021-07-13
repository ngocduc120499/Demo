package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.Products;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository(value = "productDAO")
public class ProductImp implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public List<Products> findAll(){
        Session session = this.sessionFactory.openSession();
        List<Products> result = session.createQuery("FROM Products",Products.class).getResultList();
        return result;
    }
    public void save(Products products){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(products);
            transaction.commit();

        }catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        session.close();
    }
    public void update( Products products){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(products);
        transaction.commit();
        session.close();
    }
    public void updateName(int id, String name){
        Session session = this.sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        String sql = "Update Products p SET p.name = : newName where p.id =: id";
        session.createQuery(sql).setParameter("newName",name).setParameter("id",id).executeUpdate();
        transaction.commit();
        session.close();
    }
    public void deleteProduct(int id){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Products products = session.load(Products.class, id);
        session.delete(products);
        transaction.commit();
        session.close();
    }
    public Products findByID(int id){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        return session.find(Products.class, id);

    }

}

package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.Address;
import com.example.Week2Demo.model.Customer;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@Repository(value = "customerDAO")
public class CustomerImp implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getAll() {
        Session session = this.sessionFactory.openSession();
        List<Customer> customers = session.createQuery("FROM Customer",Customer.class).getResultList();
        return customers;
    }

    @Override
    public void save(Address address) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    @Override
    public void updateNameandAddress(int id, String name, Address address) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String sql = "UPDATE Customer c set c.name = :newName, c.address = : newAddress WHERE c.id = :id";

            Query query =session.createQuery(sql).setParameter("newName", name)
                    .setParameter("newAddress", address)
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void listEmployee() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.gt("spending", 2000));
            cr.setFirstResult(1);
            cr.setMaxResults(4);
            List cust = cr.list();
            for(Iterator iterator = cust.iterator(); iterator.hasNext();){
                Customer customer = (Customer)iterator.next();
                System.out.print("Name"+customer.getName());
                System.out.println("Spending"+customer.getSpending());
            }
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null)transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

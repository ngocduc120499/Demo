package com.example.Week2Demo.Dao;

import com.example.Week2Demo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDAO")
public class UserImp implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List GetInfo() {
        Session session = this.sessionFactory.openSession();
        String hql = "SELECT u.userName,u.address FROM User u";
        Query query =  session.createQuery(hql);
        List<User> result = query.list();

         return result;
    }

    @Override
    public User getUserByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery("FROM User WHERE userName =: userName")
                .setParameter("userName",name).uniqueResult();
        transaction.commit();
        return user;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

}

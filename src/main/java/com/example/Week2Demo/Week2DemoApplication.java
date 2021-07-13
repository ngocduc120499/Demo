package com.example.Week2Demo;

import com.example.Week2Demo.Dao.CustomerDAO;
import com.example.Week2Demo.Dao.ProductImp;
import com.example.Week2Demo.Dao.UserDAO;
import com.example.Week2Demo.model.Address;
import com.example.Week2Demo.model.Customer;
import com.example.Week2Demo.model.Products;
import com.example.Week2Demo.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Week2DemoApplication {
	@Autowired
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Week2DemoApplication.class, args);
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		customerDAO.listEmployee();

//		Session session = sessionFactory.openSession();
//		List<Customer> listCust = session.createQuery("FROM Customer",Customer.class).getResultList();
//		System.out.println(listCust);

	}

}

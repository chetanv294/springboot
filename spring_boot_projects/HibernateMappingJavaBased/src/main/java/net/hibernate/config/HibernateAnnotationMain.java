package net.hibernate.config;

// import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.spring.model.Product;
import net.hibernate.config.HibernateUtilDemo;

public class HibernateAnnotationMain {

	public static void main(String[] args) {
		Product emp = new Product();
		emp.setPrice(1000); 
		emp.setProName("Developer");
		//emp.setInsertTime(new Date());
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtilDemo.getSessionAnnotationFactory();
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getProductId());
		
		
		session.close();
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}

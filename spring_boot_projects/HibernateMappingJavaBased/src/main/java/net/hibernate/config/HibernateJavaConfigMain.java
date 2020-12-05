package net.hibernate.config;

 // import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.spring.model.Product;


public class HibernateJavaConfigMain {

	public static void main(String[] args) {
		/*Product emp = new Product();
		emp.setPrice(1000); 
		emp.setProName("Dev_0");
		
		Product emp1 = new Product();
		emp1.setPrice(1000); 
		emp1.setProName("Dev_1");
		
		Product emp2 = new Product();
		emp2.setPrice(1000); 
		emp2.setProName("Dev_2");*/
		
	//	emp.setInsertTime(new Date());
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtilDemo.getSessionJavaConfigFactory_a();
		//Session session = sessionFactory.getCurrentSession();
		/** 
		Session session = sessionFactory.openSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
    	session.save(emp1);
		session.save(emp2);
		
		 session.flush();
	        session.clear();

	        
		//Commit transaction
		session.getTransaction().commit();  **/
		//System.out.println("Employee ID="+emp.getProductId());
		System.out.println("Started !!!");
		
		//session.close();
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}

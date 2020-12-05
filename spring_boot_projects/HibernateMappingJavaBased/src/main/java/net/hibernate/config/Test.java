package net.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;





// import java.util.*;
// import org.hibernate.criterion.*;


public class Test {

	private static SessionFactory sessionFactory ;
	private static Session session ;
	
	public static void main(String[] args) {
	//    HibernateUtil.setup("create table EVENTS ( uid int, name VARCHAR, start_Date date, duration int, location_id int);");
	//    HibernateUtil.setup("create table locations ( uid int, name VARCHAR, street_address VARCHAR, city VARCHAR, state VARCHAR, zip_Code VARCHAR);");
	
		new Test().getCurrentSession();
		  new Test().unsetCurrentSession();
	}
	
	public Session getCurrentSession() {
		
		sessionFactory = HibernateUtilDemo.getSessionJavaConfigFactory_a();
		session = sessionFactory.openSession();		 
		session.beginTransaction();		 
		// session.save(emp);
		
		return session;
		
		//session.getTransaction().commit();		
		//session.close();
		//terminate session factory, otherwise program won't end
		//sessionFactory.close();
	} 
	
     public void unsetCurrentSession( ) {		 
		// session.save(emp);		
		
		session.getTransaction().commit();		
		session.close();
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
}

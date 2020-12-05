package net.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
  // import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import net.spring.model.Product;

public class HibernateContext {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings( cfg.getProperties()).build();
    	
		SessionFactory factory = cfg.buildSessionFactory( serviceRegistry );
		Session session = factory.openSession();
		Product p = new Product();
		p.setProductId(105);
		p.setProName("javaFs");
		p.setPrice(15000);
		Transaction tx = session.beginTransaction();
		session.save(p);
		System.out.println("Object saved successfully using annotations.....!!");
		tx.commit();
		session.close();
		factory.close();
	}
}

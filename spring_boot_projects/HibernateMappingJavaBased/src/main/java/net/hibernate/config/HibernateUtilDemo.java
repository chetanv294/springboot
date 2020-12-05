package net.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import net.spring.model.*;
import net.spring.model.stocks.*;
public class HibernateUtilDemo {

	//XML based configuration
	private static SessionFactory sessionFactory;
	
	//Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;
	
	//Property based configuration
	private static SessionFactory sessionJavaConfigFactory;
	
	private static SessionFactory sessionJavaConfigFactory_a;

	public static SessionFactory getSessionJavaConfigFactory_a() {
		if(sessionJavaConfigFactory_a == null) sessionJavaConfigFactory_a = buildSessionJavaConfigFactory_a();
        return sessionJavaConfigFactory_a;
    }
	
	 private static SessionFactory buildSessionJavaConfigFactory_a() {
	    	try {
	    	Configuration configuration = new Configuration();
			
			//Create Properties, can be read from property files too
			Properties props = new Properties();
			props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			//props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hiber_database");
			props.put("hibernate.connection.username", "root1");
			props.put("hibernate.connection.password", "Root@1234");
			
			props.put("hibernate.show_sql", "true");
	    	props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    	props.put("hibernate.connection.pool_size", "10");
			//props.put("hibernate.current_session_context_class", "thread");
	    	props.put("hibernate.hbm2ddl.auto", "validate"); //create , validate	    	  
			
			configuration.setProperties(props);
			
			//we can set mapping file or class with annotation
			//addClass(Employee1.class) will look for resource
			// com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
		//	configuration.addAnnotatedClass(net.spring.model.stocks.Product.class);
		//	configuration.addAnnotatedClass( net.spring.model.stocks.Stock.class);
		//	configuration.addAnnotatedClass( net.spring.model.StockDailyRecord.class);
			//configuration.addAnnotatedClass( net.spring.model.StoryListGroup.class);
			//configuration.addAnnotatedClass( net.spring.model.Story.class);
			configuration.addAnnotatedClass( net.spring.model.Employee.class);
			configuration.addAnnotatedClass( net.spring.model.EDepartment.class);
		//	configuration.addAnnotatedClass( net.spring.manytomany.Event.class);
		//	configuration.addAnnotatedClass( net.spring.manytomany.Person.class);
		//	configuration.addAnnotatedClass( net.spring.manytomany.PersonEmailAdd.class);
		//	configuration.addAnnotatedClass(net.spring.auction.AuctionInfo.class );
		//	configuration.addAnnotatedClass(net.spring.auction.AuctionItem.class );
		//	configuration.addAnnotatedClass(net.spring.auction.User.class );
		//	configuration.addAnnotatedClass(net.spring.auction.Bid.class );
		//	configuration.addAnnotatedClass(net.spring.model.GameScore.class );
		//	configuration.addAnnotatedClass(net.spring.model.HighScores.class );
		//	configuration.addAnnotatedClass(net.spring.onetoone.EmployeeAddress.class);
		//	configuration.addAnnotatedClass(net.spring.onetoone.Address.class);
			/** configuration.addAnnotatedClass(net.spring.manytomany.update.Events.class);
			configuration.addAnnotatedClass(net.spring.manytomany.update.Persons.class);
			configuration.addAnnotatedClass(net.spring.manytomany.update.PersonsEvents.class);*/
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    	System.out.println("Hibernate Java Config serviceRegistry created");
	    	
	    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	
	        return sessionFactory;
	    	}
	        catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
		}
	
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionAnnotationFactory() {
    	try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate-annotation.cfg.xml");
        	System.out.println("Hibernate Annotation Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate Annotation serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}

    private static SessionFactory buildSessionJavaConfigFactory() {
    	try {
    	Configuration configuration = new Configuration();
		
		//Create Properties, can be read from property files too
		Properties props = new Properties();
		props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/mongodb_database");
		props.put("hibernate.connection.username", "root");
		props.put("hibernate.connection.password", "");
		//props.put("hibernate.current_session_context_class", "thread");
		
		configuration.setProperties(props);
		
		//we can set mapping file or class with annotation
		//addClass(Employee1.class) will look for resource
		// com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
		configuration.addAnnotatedClass(Product.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	System.out.println("Hibernate Java Config serviceRegistry created");
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
        return sessionFactory;
    	}
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
    
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	
	public static SessionFactory getSessionAnnotationFactory() {
		if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
	
	public static SessionFactory getSessionJavaConfigFactory() {
		if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }
}

package net.spring.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.hibernate.config.HibernateUtilDemo;

public class AddDeptWiseEmp {
	
	public static void main(String[] args) {
		 
		SessionFactory sessionFactory = HibernateUtilDemo.getSessionJavaConfigFactory_a();
		Session session = sessionFactory.openSession();		 
		session.beginTransaction();
		 
		// session.save(emp);
		//new AddDeptWiseEmp().addNewEmp( session );
		new AddDeptWiseEmp().one_to_m_query( session );
		
		session.getTransaction().commit();		
		session.close();
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}
	
	  void addNewEmp( Session session ) {
 
		EDepartment department = new EDepartment();
		department.setDepartmentName("Sales_V");
	//	department.setDepartmentId(1);
		//session.save(department);
		
		Employee emp1 = new Employee("Nina", "Mayers", "333");
		Employee emp2 = new Employee("Tony", "Almeida", "444");		
		emp1.setDepartment(department);
		emp2.setDepartment(department);		
		
		//department.setEmployees(new ArrayList<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		
		// List<Employee> lt = new ArrayList<Employee>();
		//lt.add(emp1); lt.add(emp2);
		//department.setEmployees( lt );
		
		
		// session.save(department);

		//session.getTransaction().commit();
		//session.close();
	}
	  
	  
	  void one_to_m_query( Session session )
	  {
		  /*String hql = "select s from EDepartment s inner join fetch s.employees as p "
		  		+ "where p.cellphone <= 444" ;*/
		  
		  String hql = "select s from EDepartment s inner join s.employees as p "
			  		+ "  where  p.cellphone <= 444" ;
		  
		  org.hibernate.Query q = session.createQuery(hql);
		  //q.getNamedParameters()
	        List results = q.list();
	        
	        Iterator it =  results.iterator(); 

			while(it.hasNext()) {
				EDepartment str = (EDepartment)	it.next();
				System.out.println( str.getDepartmentName() );
				for(Employee emp : str.getEmployees()) {
					System.out.print( emp.getFirstname() +" ,");
				}
				System.out.println();
			}
	  }
}

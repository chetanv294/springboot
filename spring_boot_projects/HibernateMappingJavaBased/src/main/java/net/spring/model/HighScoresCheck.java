package net.spring.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.hibernate.config.HibernateUtilDemo;

public class HighScoresCheck {
	private static SessionFactory sessionFactory ;
	private static Session session ;
	
	public static void main(String[] args) {
	 HighScores sp = new HighScores("HighScores Name");
     
     HashSet<GameScore> set = new HashSet<GameScore>();
     set.add(new GameScore("GameScore Name 1", 3));
     set.add(new GameScore("GameScore Name 2", 2));
     sp.setGames(set);

     session = getCurrentSession();
   //  session.save(sp);
     displaySupplierList();
     session.flush();
     session.getTransaction().commit();		
		session.close();
		
		sessionFactory.close();
	}
     public static Session getCurrentSession() {
 		
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
     
     public static void displaySupplierList(){
     
     
        String hql = "from HighScores s inner join fetch s.games as p";
        List results = session.createQuery(hql).list();
        
        Iterator it =  results.iterator(); 

		while(it.hasNext()) {
			HighScores str = (HighScores)	it.next();
			System.out.println( str.getId() );
			System.out.println( str.getName() );
			
			Set<GameScore> grplist = str.getGames();
			Iterator grp =  grplist.iterator(); 
			while(grp.hasNext()) {
				GameScore strg = (GameScore)	grp.next();
				System.out.println(strg.getId() + strg.getName()  );
				System.out.println( strg.getScore() );
			}

		}
      // displaySupplierList(results);
     }
}

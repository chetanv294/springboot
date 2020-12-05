package net.spring.dao;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.hibernate.Criteria;
import org.hibernate.Session;
 

 
import net.hibernate.config.Test;
import net.spring.model.Story;
import net.spring.model.StoryListGroup;
 

public class StoryListDao {

	List<StoryListGroup> listUser ;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		
		 listview_1( );System.exit(1);
		 
		Test conectionPool = new Test();
		Session session =  conectionPool.getCurrentSession();		 
		
		StoryListDao test =      new	StoryListDao();
	//	test.list( session );
		test.listviewperid(  session );
		
		conectionPool.unsetCurrentSession();
		
	//	test.listview();
	}
	
	 
	public void  listviewperid(Session sess  ) {
		
		StoryListGroup fritz = (StoryListGroup) sess.load( StoryListGroup.class, 14);
		 listUser = new ArrayList<StoryListGroup>();
		 listUser.add( fritz );
		 
		Iterator it =  listUser.iterator(); 

		while(it.hasNext()) {
			StoryListGroup str = (StoryListGroup)	it.next();
			System.out.println( str.getName() );
			
			List<Story> grplist = str.getStories();
			Iterator grp =  grplist.iterator(); 
			while(grp.hasNext()) {
				Story strg = (Story)	grp.next();
				System.out.println( strg.getInfo() );
			}

		}
	}
 
	public List<StoryListGroup> list( Session session ) {
		 
		  listUser = (List<StoryListGroup>) session.createCriteria( StoryListGroup.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	
	public void  listview( ) {
		 
		Iterator it =  listUser.iterator(); 

		while(it.hasNext()) {
			StoryListGroup str = (StoryListGroup)	it.next();
			System.out.println( str.getName() );
			
			List<Story> grplist = str.getStories();
			Iterator grp =  grplist.iterator(); 
			while(grp.hasNext()) {
				Story strg = (Story)	grp.next();
				System.out.println( strg.getInfo() );
			}

		}
	}
	
	public static void  listview_1( ) { 
		Queue q = new LinkedList();
		
		List newlist = new ArrayList();
		for(int i=0;i<=100;i++) {
			newlist.add( null );
		}
		 
		Iterator it =  newlist.iterator(); 

		while(it.hasNext()) {
			 	
			System.out.println( it.next() );
			
		   }  

		}
	 
}

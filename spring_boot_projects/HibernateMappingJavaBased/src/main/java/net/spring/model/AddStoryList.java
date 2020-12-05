package net.spring.model;

 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import net.hibernate.config.Test;
 

public class AddStoryList {

	
	public static void main(String[] args) {		 
		 
		Test conectionPool = new Test();
		Session session =  conectionPool.getCurrentSession();		 
		
		new AddStoryList().addNewStory( session );		
		
		conectionPool.unsetCurrentSession();
	}
	
	void addNewStory( Session session ) {
		
		StoryListGroup sp = new StoryListGroup("Group Name5");
		
		 
	      List<Story> list = new ArrayList<Story>();
	      Story s1 = new Story("Story Name.5.1" );
	      Story s2 = new Story("Story Name.5.2" );
	      list.add( s1 );
	      list.add( s2 );
	      
	      s1.setStorylistgroup(sp);
	      s2.setStorylistgroup(sp);
	      
	      sp.setStories(list);

	      session.save(sp);
	      session.save( s1 );
	      session.save( s2 );

	}
	
	 
	 
}

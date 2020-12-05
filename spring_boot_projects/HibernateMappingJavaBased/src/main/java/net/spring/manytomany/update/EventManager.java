package net.spring.manytomany.update;

import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import net.hibernate.config.HibernateUtilDemo;

import java.util.*;



public class EventManager {

    public static void main(String[] argsc) {
        EventManager mgr = new EventManager();
        String args[]= {"list"};//{"list,addpersontoevent,addemailtoperson"};
        
    //    mgr.listPersonOfEvent(1L,1L);
        
        
        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        }
        else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Events theEvent = (Events) events.get(i);
                System.out.println("Event: " + theEvent.getTitle() +
                                   " Time: " + theEvent.getDate());
              for( PersonsEvents  eplist:  theEvent.getParticipants()) {
            	   System.out.print(eplist.getPersonslist().getFirstname() + "\t");
            	   System.out.print(eplist.getPersonslist().getLastname());  
            	   System.out.println();
              }
            }
        }
        else if (args[0].equals("addpersontoevent")) {
            Long eventId = mgr.createAndStoreEvent("My Event new", new Date());
            Long personId = mgr.createAndStorePerson("app", "get");
            mgr.addPersonToEvent(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        }
        else if (args[0].equals("addemailtoperson")) {
            Long personId = mgr.createAndStorePerson("Foozy", "Beary");
            mgr.addEmailToPerson(personId, "foo@bar");
            mgr.addEmailToPerson(personId, "bar@foo");
            System.out.println("Added two email addresses (value typed objects) to person entity : " + personId);
        }

        HibernateUtilDemo.getSessionJavaConfigFactory_a().close();
    }

    private Long createAndStoreEvent(String title, Date theDate) {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Events theEvent = new Events();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);

        session.save(theEvent);

        session.getTransaction().commit();

        return theEvent.getId();
    }

    private Long createAndStorePerson(String firstname, String lastname) {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Persons thePerson = new Persons();
        thePerson.setFirstname(firstname);
        thePerson.setLastname(lastname);

        session.save(thePerson);

        session.getTransaction().commit();

        return thePerson.getId();
    }


    private List listEvents() {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        List result = session.createQuery("from Events").list();
        
       // session.createCriteria(Events.class).createAlias("rentals", "rent");

        session.getTransaction().commit();

        return result;
    }

    private void addPersonToEvent(Long personId, Long eventId) {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Persons aPerson = (Persons) session
                .createQuery("select p from Persons p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached

      //  Event anEvent = (Event) session.load(Event.class, eventId);
        // If we want to handle it bidirectional and detached, we also need to load this
        // collection with an eager outer-join fetch, this time with Criteria and not HQL:
         
        Events anbiEvent = (Events) session
                .createCriteria(Events.class).setFetchMode("participants", FetchMode.JOIN)
                .add( Expression.eq("id", eventId) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
         

        session.getTransaction().commit();
        session.close();
        // End of first unit of work

       //  aPerson.addToEvent(anbiEvent); 
      //  aPerson.getEvents().add(anbiEvent); // aPerson is detached
        // or bidirectional safety method, setting both sides: aPerson.addToEvent(anEvent);
      //  anbiEvent.getParticipants().add(aPerson); 
        
        // Begin second unit of work

        Session session2 = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session2.beginTransaction();

        session2.update( anbiEvent);
       // session2.update(aPerson); // Reattachment of aPerson
         
        
        session2.getTransaction().commit();
        session2.close();
    }

    private void addEmailToPerson(Long personId, String emailAddress) {

      //  Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
      //  session.beginTransaction();

        //Persons aPerson = (Persons) session.load(Persons.class, personId);

        // The getEmailAddresses() might trigger a lazy load of the collection
       // aPerson.getEmailAddresses().add(emailAddress);
       /* PersonEmailAdd personemail = new PersonEmailAdd();
        personemail.setEmailadd(emailAddress);
        personemail.setPerson(aPerson);
        aPerson.getEmailAddresses().add(personemail);*/
        
      //  session.getTransaction().commit();
    }

    
    private void listPersonOfEvent(Long personId, Long eventId) {
   try {
        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        /*Persons usr = new Persons();
        usr.setId(10L);
        usr.setAge(20);
        usr.setFirstname("f_per_1");
        usr.setLastname("last_name");*/
        
        Criteria criteria = session.createCriteria(Persons.class).add(Restrictions.eq("id", 10L ));
        
        Persons data = (Persons)criteria.uniqueResult();
        
       /* Events ev = new Events();
         ev.setId(9L);
         ev.setDate(new Date());
         ev.setTitle("event_0");
        
         Events ev1 = new Events();
         ev.setId(10L);
         ev1.setDate(new Date());
         ev1.setTitle("event_1");*/
         
         //List evlistfresh = new ArrayList();
         List<PersonsEvents> evlist = data.getPersondata();
         Iterator<PersonsEvents> itr = evlist.iterator();
         
         while( itr.hasNext()) {
        	 PersonsEvents pont = itr.next();
        	 pont.getEventslist();
        	 itr.remove();
         }       
         
        // evlistfresh.add(ev);
        // evlistfresh.add(ev1);         
         // usr.setParticipants( evlist );
         Criteria criteria1 = session.createCriteria(Events.class).add(Restrictions.eq("id", 9L ));         
         Events dbevnt1 = (Events)criteria1.uniqueResult();
         
         Criteria criteria2 = session.createCriteria(Events.class).add(Restrictions.eq("id", 11L ));         
         Events dbevnt2 = (Events)criteria2.uniqueResult();
         
         PersonsEvents pevent1 = new PersonsEvents();
         pevent1.setPersonslist(data);
         pevent1.setEventslist(dbevnt1);
         pevent1.setOrderapp(1);
         
         PersonsEvents pevent2 = new PersonsEvents();
         pevent2.setPersonslist(data);
         pevent2.setEventslist(dbevnt2);
         pevent2.setOrderapp(2);
         
        // evlist.add(pevent1);
       //  evlist.add(pevent2);
         data.getPersondata().add(pevent1);
         data.getPersondata().add(pevent2);
         
        // pevent1.setPersonslist(data);
       //  pevent1.setEventslist(dbevnt2);
         //dbevnt1.getParticipants().add(pevent1);
         //dbevnt2.getParticipants().add(pevent1);
        // dbevnt2.getParticipants().add(pevent2);
         
       //  data.setParticipants( evlist );
         
       // PersonsEvents pevent = new PersonsEvents();
      //   pevent.setEventslist(ev); 
       //  pevent.setPersonslist(usr);
      //  pevent.setPersonslist(  data );
         
        // session.persist(pevent);
        session.saveOrUpdate(data);
      //  session.persist(pevent2);
        
       /* Persons aPerson = (Persons) session
                .createQuery("select p from Persons p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); */
        
        // Eager fetch the collection so we can use it detached

      //  Event anEvent = (Event) session.load(Event.class, eventId);
        // If we want to handle it bidirectional and detached, we also need to load this
        // collection with an eager outer-join fetch, this time with Criteria and not HQL:
         
       /* Events anbiEvent = (Events) session
                .createCriteria(Events.class).setFetchMode("participants", FetchMode.JOIN)
                .add( Expression.eq("id", eventId) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
         */

       /* Events anbiEvent = (Events) session
                .createCriteria(Events.class).setFetchMode("participants", FetchMode.JOIN);
                
        System.out.println( anbiEvent );*/
        
        session.getTransaction().commit();
        session.close();
        // End of first unit of work

      //  aPerson.addToEvent(anbiEvent);
      //  aPerson.getEvents().add(anbiEvent); // aPerson is detached
        // or bidirectional safety method, setting both sides: aPerson.addToEvent(anEvent);
      //  anbiEvent.getParticipants().add(aPerson); 
        
        // Begin second unit of work
      }catch(Exception ex) {}
            }
}
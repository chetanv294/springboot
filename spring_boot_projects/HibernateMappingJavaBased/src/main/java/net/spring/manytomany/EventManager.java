package net.spring.manytomany;

import org.hibernate.*;
import org.hibernate.criterion.Expression;

import net.hibernate.config.HibernateUtilDemo;

import java.util.*;



public class EventManager {

    public static void main(String[] argsc) {
        EventManager mgr = new EventManager();
        String args[]= {"addpersontoevent"};
      //  String args[]= {"list"};
        
        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        }
        else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                System.out.println("Event: " + theEvent.getTitle() +
                                   " Time: " + theEvent.getDate());
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

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);

        session.save(theEvent);

        session.getTransaction().commit();

        return theEvent.getId();
    }

    private Long createAndStorePerson(String firstname, String lastname) {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Person thePerson = new Person();
        thePerson.setFirstname(firstname);
        thePerson.setLastname(lastname);

        session.save(thePerson);

        session.getTransaction().commit();

        return thePerson.getId();
    }


    private List listEvents() {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        List result = session.createQuery("from Event").list();

        session.getTransaction().commit();

        return result;
    }

    private void addPersonToEvent(Long personId, Long eventId) {

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Person aPerson = (Person) session
                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached

      //  Event anEvent = (Event) session.load(Event.class, eventId);
        // If we want to handle it bidirectional and detached, we also need to load this
        // collection with an eager outer-join fetch, this time with Criteria and not HQL:
         
        Event anbiEvent = (Event) session
                .createCriteria(Event.class).setFetchMode("participants", FetchMode.JOIN)
                .add( Expression.eq("id", eventId) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
         

        session.getTransaction().commit();
        session.close();
        // End of first unit of work

        aPerson.addToEvent(anbiEvent);
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

        Session session = HibernateUtilDemo.getSessionJavaConfigFactory_a().openSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);

        // The getEmailAddresses() might trigger a lazy load of the collection
       // aPerson.getEmailAddresses().add(emailAddress);
        PersonEmailAdd personemail = new PersonEmailAdd();
        personemail.setEmailadd(emailAddress);
        personemail.setPerson(aPerson);
        aPerson.getEmailAddresses().add(personemail);
        
        session.getTransaction().commit();
    }

}
package net.spring.manytomany;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "age",  length = 20)
    private int age;
	
	@Column(name = "firstname", length = 20)
    private String firstname;
	
	@Column(name = "lastname", length = 20)
    private String lastname;

    public Person() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

/*
    @OneToMany(
            targetEntity=net.spring.manytomany.Person.class,
            cascade={CascadeType.PERSIST, CascadeType.MERGE}
        )
    @JoinTable(
            name="PERSON_EMAIL_ADDR",
            joinColumns=@JoinColumn(name="PERSON_ID" )                   
        )*/
    
    @OneToMany(
    		mappedBy = "person",
            targetEntity=net.spring.manytomany.PersonEmailAdd.class,
            cascade={CascadeType.ALL}
        )
    private Set emailAddresses = new HashSet();

    public Set getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
  
    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "participants",
            targetEntity = net.spring.manytomany.Event.class
        )
    private Set events = new HashSet();

    // Defensive, convenience methods
    protected Set getEvents() {
        return events;
    }

    protected void setEvents(Set events) {
        this.events = events;
    }

    public void addToEvent(Event event) {
        this.getEvents().add(event);
        event.getParticipants().add(this);
    }

    public void removeFromEvent(Event event) {
        this.getEvents().remove(event);
        event.getParticipants().remove(this);
    }

}
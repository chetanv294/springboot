package net.spring.manytomany.update;

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
@Table(name = "UPDATE_PERSON")
public class Persons {

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
	
    @OneToMany(mappedBy = "personslist")
	private List<PersonsEvents> persondata = new ArrayList<PersonsEvents>();

    public Persons() {}


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


	public List<PersonsEvents> getPersondata() {
		return persondata;
	}


	public void setPersondata(List<PersonsEvents> persondata) {
		this.persondata = persondata;
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
    
    /*@OneToMany(
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
    }*/
  
    /*@ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "participants",
            targetEntity = net.spring.manytomany.update.Events.class
        )*/
    
    
   
    

    // Defensive, convenience methods

/*    public List<PersonsEvents> getParticipants() {
		return participants;
	}


	public void setParticipants(List<PersonsEvents> participants) {
		this.participants = participants;
	}*/

    /*public void addToEvent(Events event) {
        this.getEvents().add(event);
        event.getParticipants().add(this);
    }

    public void removeFromEvent(Events event) {
        this.getEvents().remove(event);
        event.getParticipants().remove(this);
    }*/

}
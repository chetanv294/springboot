package net.spring.manytomany.update;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@Table(name = "UPDATE_EVENTS")
public class Events implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Long id;

	@Column(name = "title",  length = 20)
    private String title;
	
	@Column(name = "date", length = 20)
    private Date date;

	@OneToMany(mappedBy = "eventslist")
	private List<PersonsEvents> participants = new ArrayList<PersonsEvents>();
	 
    public Events() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    /*@ManyToMany(
            targetEntity=net.spring.manytomany.update.Persons.class,
            cascade={CascadeType.PERSIST, CascadeType.MERGE}
        )
    @JoinTable(
            name="UPDATE_PERSONS_EVENTS",
            joinColumns=@JoinColumn(name="EVENT_ID"),
            inverseJoinColumns=@JoinColumn(name="PERSON_ID")
        )*/
    
    
   

    
    public List<PersonsEvents> getParticipants() {
        return participants;
    }

    public void setParticipants(List<PersonsEvents> participants) {
        this.participants = participants;
    }

}
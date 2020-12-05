package net.spring.manytomany.update;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "UPDATE_PERSONS_EVENTS_EXTRA_1")
public class PersonsEvents {

		@Id
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
	    private int id;
	
		@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "persons_id")
		private Persons personslist;
	
		@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "events_id")
	    private Events  eventslist;
	     
	    // additional fields
	    @Column(name = "orderapp")
	    private int orderapp;

	    public PersonsEvents(){
	    	
	    }
	    

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		 
		public Persons getPersonslist() {
			return personslist;
		}

		public void setPersonslist(Persons personslist) {
			this.personslist = personslist;
		}

		
		 
		public Events getEventslist() {
			return eventslist;
		}

		public void setEventslist(Events eventslist) {
			this.eventslist = eventslist;
		}


		public int getOrderapp() {
			return orderapp;
		}

		public void setOrderapp(int orderapp) {
			this.orderapp = orderapp;
		}
	
}

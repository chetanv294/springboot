package net.spring.manytomany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 

@Entity
@Table(name = "PERSON_EMAIL_ADDR")
public class PersonEmailAdd {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "emailadd", length = 20)
    private String emailadd;
	
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmailadd() {
		return emailadd;
	}


	public void setEmailadd(String emailadd) {
		this.emailadd = emailadd;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}

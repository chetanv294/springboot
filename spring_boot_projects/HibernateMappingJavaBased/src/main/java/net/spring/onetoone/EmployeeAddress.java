package net.spring.onetoone;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="onetoone_emp")
public class EmployeeAddress {
	
	 @Id
	   @GeneratedValue(strategy = IDENTITY)
	   @Column(name = "emp_id")
	int id;
	 
	 @Column(name = "name")
	String name;
	 
	 @Column(name = "email")
	String email;
	 
	 @Column(name = "empcode")
	String empcode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	
	
}

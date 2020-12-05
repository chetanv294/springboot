package net.spring.onetoone;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="onetoone_emp_address")
public class Address {

   @Id
   @GeneratedValue(strategy = IDENTITY)
   @Column(name = "add_id")
   private	int id;
	
   @Column(name = "address")
   private String address;
	
   /*@JoinColumn(name="emp_emp_id",referencedColumnName="emp_id")  cascade={CascadeType.ALL},*/
   @OneToOne(fetch = FetchType.EAGER,targetEntity=net.spring.onetoone.EmployeeAddress.class)	
   @JoinColumn(name="emp_emp_id",referencedColumnName="emp_id",foreignKey = @ForeignKey(name = "FK_EMP_ADDRESS"))
   private EmployeeAddress emp;
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public EmployeeAddress getEmp() {
	return emp;
}
public void setEmp(EmployeeAddress emp) {
	this.emp = emp;
}	
	 
}

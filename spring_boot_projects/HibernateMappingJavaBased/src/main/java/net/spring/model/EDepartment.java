package net.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
 //import org.hibernate.annotations.IndexColumn;

// @SuppressWarnings("deprecation")
@Entity
@Table(name="EDEPARTMENT")
public class EDepartment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="DEPARTMENT_ID")
	@ColumnDefault("1")
	private int departmentId ;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
 
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="department_id")
	// @IndexColumn(name="idx")
	@OrderColumn(name="idx")
	private List<Employee> employees = new ArrayList<Employee>();


	public int getDepartmentId() {
		return this.departmentId;
	}


	public void setDepartmentId( int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return this.departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public List<Employee> getEmployees() {
		return this.employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	// Getter and Setter methods
	
}


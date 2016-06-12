package com.hr.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee {

	@Id
	@Column(name="emp_no")
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	@NotEmpty
	private Date birthDate;

	@Column(name="first_name",length=14)
	@NotEmpty
	private String firstName;

	@Column(name="last_name", length=16)
	@NotEmpty
	private String lastName;
	
	//implement ENUM here

	@Column(name="gender", length=2)
	@NotEmpty
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	@NotEmpty
	private Date hireDate;
	
	//---------Entity relationship-------
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
	private List<Salary> salaries;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
	private List<Title> titles;
	
    @OneToMany(mappedBy="employees", targetEntity=DeptEmp.class)
    private List<DeptEmp> listOfDeptEmp;

    @OneToMany(mappedBy="employees", targetEntity=DeptManager.class)
    private List<DeptManager> listOfDeptManager;

	public Employee() {	
	}
	
	
	//------GETTER and SETTER for primary key-----
	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	//------GETTER and SETTER for fields-----
	
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	//SETTERS and GETTER for relationships

	   public void setListOfDeptEmp( List<DeptEmp> listOfDeptEmp ) {
	        this.listOfDeptEmp = listOfDeptEmp;
	    }
	    public List<DeptEmp> getListOfDeptEmp() {
	        return this.listOfDeptEmp;
	    }

	    public void setListOfDeptManager( List<DeptManager> listOfDeptManager ) {
	        this.listOfDeptManager = listOfDeptManager;
	    }
	    public List<DeptManager> getListOfDeptManager() {
	        return this.listOfDeptManager;
	    }
	
	
	public List<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}
	
	public List<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}
	
	// ADD and REMOVE

	public Title addTitle(Title title) {
		getTitles().add(title);
		title.setEmployee(this);

		return title;
	}

	public Title removeTitle(Title title) {
		getTitles().remove(title);
		title.setEmployee(null);

		return title;
	}

	public Salary addSalary(Salary salary) {
		getSalaries().add(salary);
		salary.setEmployee(this);

		return salary;
	}

	public Salary removeSalary(Salary salary) {
		getSalaries().remove(salary);
		salary.setEmployee(null);

		return salary;
	}

}
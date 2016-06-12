package com.hr.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="salaries")
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary {

	@EmbeddedId
	private SalaryPK salaryPk;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_no")
	private Employee employee;

	/** _______________________________________________________________________________*/

	private int salary;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	/** _______________________________________________________________________________*/

	public SalaryPK getSalaryPK() { return this.salaryPk;}

	public void setSalaryPK(SalaryPK salaryPk) {this.salaryPk = salaryPk;}
	

	public Employee getEmployee() { return this.employee;}

	public void setEmployee(Employee employee) {this.employee = employee;}

	/** _______________________________________________________________________________*/
	
	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public Salary() {
	}

}
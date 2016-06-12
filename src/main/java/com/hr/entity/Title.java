package com.hr.entity;


import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the titles database table.
 * 
 */
@Entity
@Table(name="titles")
@NamedQuery(name="Title.findAll", query="SELECT t FROM Title t")
public class Title {

	@EmbeddedId
	private TitlePK titlePk;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_no")
	private Employee employee;

	public Title() {
	}

	public TitlePK getTitlePK() {
		return this.titlePk;
	}

	public void setTitlePK(TitlePK titlePk) {
		this.titlePk= titlePk;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
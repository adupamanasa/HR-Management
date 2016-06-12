package com.hr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The primary key class for the salaries database table.
 * 
 */
@Embeddable
public class SalaryPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**-----------------Composite Primary Key---------------*/

	@Column(name="emp_no", insertable=false, updatable=false, nullable=false)
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;
	
	
	public int getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public Date getFromDate() {
		return this.fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalaryPK)) {
			return false;
		}
		SalaryPK castOther = (SalaryPK)other;
		return 
			(this.empNo == castOther.empNo)
			&& this.fromDate.equals(castOther.fromDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empNo;
		hash = hash * prime + this.fromDate.hashCode();
		
		return hash;
	}
}
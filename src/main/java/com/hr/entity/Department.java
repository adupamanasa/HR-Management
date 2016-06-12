package com.hr.entity;


import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="departments")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department {

	@Id
	@Column(name="dept_no", nullable=false,  length=4)
	private String deptNo;

	@Column(name="dept_name", nullable=false,  length=40)
	private String deptName;

	@OneToMany(mappedBy="departments", targetEntity=DeptEmp.class)
	private List<DeptEmp> listOfDeptEmp;

	@OneToMany(mappedBy="departments", targetEntity=DeptManager.class)
	private List<DeptManager> listOfDeptManager;

	public Department() {
	}

	// SETTER AND GETTERS
	
	public String getDeptNo() {
		return this.deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	//

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

}
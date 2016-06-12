package com.hr.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="dept_emp", catalog="employees" )
@NamedQueries ( {
  @NamedQuery ( name="DeptEmp.findAll", query="SELECT x FROM DeptEmp x" )
} )
public class DeptEmp {

    
    // ENTITY PRIMARY KEY
    
	@EmbeddedId
    private DeptEmpManagerPK deptEmpManagerPk ;

	
    // ENTITY DATA FIELDS 
   
    @Temporal(TemporalType.DATE)
    @Column(name="from_date", nullable=false)
    private Date       fromDate     ;

    @Temporal(TemporalType.DATE)
    @Column(name="to_date", nullable=false)
    private Date       toDate       ;

    // ENTITY LINKS ( RELATIONSHIP )

    @ManyToOne
    @JoinColumn(name="dept_no", referencedColumnName="dept_no", insertable=false, updatable=false)
    private Department department ;

    @ManyToOne
    @JoinColumn(name="emp_no", referencedColumnName="emp_no", insertable=false, updatable=false)
    private Employee employee   ;

    
    // CONSTRUCTOR(S)
    
    public DeptEmp() {
		super();
		this.deptEmpManagerPk = new DeptEmpManagerPK();       
    }
    
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    
    public void setEmpNo( Integer empNo ) {
        this.deptEmpManagerPk.setEmpNo( empNo ) ;
    }
    public Integer getEmpNo() {
        return this.deptEmpManagerPk.getEmpNo() ;
    }
    public void setDeptNo( String deptNo ) {
        this.deptEmpManagerPk.setDeptNo( deptNo ) ;
    }
    public String getDeptNo() {
        return this.deptEmpManagerPk.getDeptNo() ;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : from_date ( DATE ) 
    public void setFromDate( Date fromDate ) {
        this.fromDate = fromDate;
    }
    public Date getFromDate() {
        return this.fromDate;
    }

    //--- DATABASE MAPPING : to_date ( DATE ) 
    public void setToDate( Date toDate ) {
        this.toDate = toDate;
    }
    public Date getToDate() {
        return this.toDate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setDepartment( Department department ) {
        this.department = department;
    }
    public Department getDepartment() {
        return this.department;
    }

    public void setEmployees( Employee employee ) {
        this.employee = employee;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
}

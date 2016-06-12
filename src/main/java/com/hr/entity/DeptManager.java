package com.hr.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="dept_manager", catalog="employees" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DeptManager.findAll", query="SELECT x FROM DeptManager x" )
} )
public class DeptManager {
 
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
    
   public DeptManager() {
	super();
	this.deptEmpManagerPk = new DeptEmpManagerPK();       
    }
    
   
    // GETTER & SETTER FOR THE COMPOSITE KEY 

    public void setDeptNo( String deptNo ) {
        this.deptEmpManagerPk.setDeptNo( deptNo ) ;
    }
    public String getDeptNo() {
        return this.deptEmpManagerPk.getDeptNo() ;
    }
    public void setEmpNo( Integer empNo ) {
        this.deptEmpManagerPk.setEmpNo( empNo ) ;
    }
    public Integer getEmpNo() {
        return this.deptEmpManagerPk.getEmpNo() ;
    }

    
    // GETTERS & SETTERS FOR FIELDS
    
    public void setFromDate( Date fromDate ) {
        this.fromDate = fromDate;
    }
    public Date getFromDate() {
        return this.fromDate;
    }

    public void setToDate( Date toDate ) {
        this.toDate = toDate;
    }
    public Date getToDate() {
        return this.toDate;
    }

    // GETTERS & SETTERS FOR LINKS
    
    public void setDepartments( Department department ) {
        this.department = department;
    }
    public Department getDepartment() {
        return this.department;
    }

    public void setEmployee( Employee employee ) {
        this.employee = employee;
    }
    public Employee getEmployee() {
        return this.employee;
    }


    
    // toString METHOD
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        if ( deptEmpManagerPk != null ) {  
            sb.append(deptEmpManagerPk.toString());  
        }  
        else {  
            sb.append( "(null-key)" ); 
        }  
        sb.append("]:"); 
        sb.append(fromDate);
        sb.append("|");
        sb.append(toDate);
        return sb.toString(); 
    } 

}
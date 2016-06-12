package com.hr.entity;
import java.io.Serializable;

import javax.persistence.*;

 @Embeddable
public class DeptEmpManagerPK implements Serializable {

    private static final long serialVersionUID = 1L;

    // ENTITY KEY ATTRIBUTES 
    
    @Column(name="emp_no", nullable=false)
    private Integer    empNo        ;
    
    @Column(name="dept_no", nullable=false, length=4)
    private String     deptNo       ;
    

    // CONSTRUCTORS
   
    public DeptEmpManagerPK() {
        super();
    }

    public DeptEmpManagerPK( Integer empNo, String deptNo ) {
        super();
        this.empNo = empNo ;
        this.deptNo = deptNo ;
    }
    
    // GETTERS & SETTERS FOR KEY FIELDS
    
    public void setEmpNo( Integer value ) {
        this.empNo = value;
    }
    
    public Integer getEmpNo() {
        return this.empNo;
    }

    public void setDeptNo( String value ) {
        this.deptNo = value;
    }
    public String getDeptNo() {
        return this.deptNo;
    }


    // equals METHOD

	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		DeptEmpManagerPK other = (DeptEmpManagerPK) obj; 
		//--- Attribute empNo
		if ( empNo == null ) { 
			if ( other.empNo != null ) 
				return false ; 
		} else if ( ! empNo.equals(other.empNo) ) 
			return false ; 
		//--- Attribute deptNo
		if ( deptNo == null ) { 
			if ( other.deptNo != null ) 
				return false ; 
		} else if ( ! deptNo.equals(other.deptNo) ) 
			return false ; 
		return true; 
	} 

    // hashCode METHOD
   
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute empNo
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode() ) ; 
		//--- Attribute deptNo
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode() ) ; 
		
		return result; 
	} 

    // toString METHOD
    
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(empNo); 
		sb.append("|"); 
		sb.append(deptNo); 
        return sb.toString();
    }
}
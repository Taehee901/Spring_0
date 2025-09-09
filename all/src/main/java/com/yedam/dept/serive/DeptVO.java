package com.yedam.dept.serive;

/**
 * @Class Name : DeptVO.java
 * @Description : Dept VO class
 * @Modification Information
 *
 * @author 김유미
 * @since 2025-09-09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class DeptVO extends DeptDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** ID */
    private java.math.BigDecimal id;
    
    /** DNAME */
    private java.lang.String dname;
    
    /** LOCATION */
    private java.lang.String location;
    
    /** MANAGER_ID */
    private java.math.BigDecimal managerId;
    
    public java.math.BigDecimal getId() {
        return this.id;
    }
    
    public void setId(java.math.BigDecimal id) {
        this.id = id;
    }
    
    public java.lang.String getDname() {
        return this.dname;
    }
    
    public void setDname(java.lang.String dname) {
        this.dname = dname;
    }
    
    public java.lang.String getLocation() {
        return this.location;
    }
    
    public void setLocation(java.lang.String location) {
        this.location = location;
    }
    
    public java.math.BigDecimal getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(java.math.BigDecimal managerId) {
        this.managerId = managerId;
    }
    
}

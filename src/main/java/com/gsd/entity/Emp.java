package com.gsd.entity;

import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Emp.java
 * @Description TODO
 * @createTime 2023年09月06日 13:02:00
 */
public class Emp {
    //使用iDea的数据库反向建Entity？
    private long empno;
    private String ename;
    private String job;
    private long mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private long deptno;
    private long status;


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }


    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public long getMgr() {
        return mgr;
    }

    public void setMgr(long mgr) {
        this.mgr = mgr;
    }


    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }


    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }


    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                ", status=" + status +
                '}';
    }
}

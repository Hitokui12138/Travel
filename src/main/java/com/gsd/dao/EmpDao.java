package com.gsd.dao;


import com.gsd.entity.Emp;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EmpDao.java
 * @Description TODO
 * @createTime 2023年09月06日 14:43:00
 */
public interface EmpDao {
    /**
     * 如何让mapper知道要生成哪个方法？
     * 1.让mapper的namespace指向接口 <mapper namespace="com.com.gsd.dao.EmpDao">
     * 2.接口的方法和参数保持一致
     */
    public int addEmp(Emp emp);
    public int updateEmp(Emp emp);
    public int deleteEmp(int empno);
    public Emp detail(int empno);
    public List<Emp> findAll();


}

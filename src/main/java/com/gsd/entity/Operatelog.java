package com.gsd.entity;

import java.io.Serializable;

/**
 * operatelog
 * @author 
 */
public class Operatelog implements Serializable {
    private Integer id;

    private String operatemsg;

    private String logtype;

    private String requestmethod;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperatemsg() {
        return operatemsg;
    }

    public void setOperatemsg(String operatemsg) {
        this.operatemsg = operatemsg;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }

    public String getRequestmethod() {
        return requestmethod;
    }

    public void setRequestmethod(String requestmethod) {
        this.requestmethod = requestmethod;
    }
}
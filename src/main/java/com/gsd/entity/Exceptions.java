package com.gsd.entity;

import java.io.Serializable;

/**
 * exception
 * @author 
 */
public class Exceptions implements Serializable {
    private Integer id;

    private String methodname;

    private String methodtype;

    private String requesttype;

    private String ip;

    private String url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public String getMethodtype() {
        return methodtype;
    }

    public void setMethodtype(String methodtype) {
        this.methodtype = methodtype;
    }

    public String getRequesttype() {
        return requesttype;
    }

    public void setRequesttype(String requesttype) {
        this.requesttype = requesttype;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
package com.gsd.vo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Result.java
 * @Description TODO
 * @createTime 2023年09月12日 11:08:00
 */
public class Result {
    private boolean success = true;
    private String message;
    private Object object;//将来想用Result返回一个结果或者集合

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(String message, Object object) {

        this.message = message;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

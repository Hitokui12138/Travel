package com.gsd.exception;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserNameException.java
 * @Description 看一下自定义异常怎么写
 * @createTime 2023年09月18日 09:58:00
 */
public class UserNameException extends RuntimeException{
    private static final long serialVersionUID = 3031265789981078414L;
    //1.序列化

    //2. Override
    public UserNameException() {
        super();
    }

    public UserNameException(String message) {
        super(message);
    }

    public UserNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameException(Throwable cause) {
        super(cause);
    }

    protected UserNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

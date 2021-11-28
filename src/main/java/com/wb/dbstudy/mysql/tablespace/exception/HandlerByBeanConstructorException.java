package com.wb.dbstudy.mysql.tablespace.exception;

public class HandlerByBeanConstructorException extends RuntimeException {
    public HandlerByBeanConstructorException(Exception e) {
        super("未找到构造器方法", e);
    }
}

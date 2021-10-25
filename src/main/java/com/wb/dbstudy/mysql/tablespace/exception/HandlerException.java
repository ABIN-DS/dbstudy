package com.wb.dbstudy.mysql.tablespace.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title HandlerException
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 11:06 上午
 */
@Data
public class HandlerException extends RuntimeException{
    private Class clazz;

    public HandlerException(Class clazz){
        super();
        this.clazz = clazz;
    }
}

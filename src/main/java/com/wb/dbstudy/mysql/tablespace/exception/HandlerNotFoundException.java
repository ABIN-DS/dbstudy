package com.wb.dbstudy.mysql.tablespace.exception;

import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title HandlerNotFoundException
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 11:11 上午
 */
public class HandlerNotFoundException extends HandlerException{
    public HandlerNotFoundException(Class clazz){
        super(clazz);
    }
}

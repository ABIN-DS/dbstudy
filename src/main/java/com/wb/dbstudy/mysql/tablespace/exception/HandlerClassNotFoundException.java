package com.wb.dbstudy.mysql.tablespace.exception;

import com.wb.dbstudy.mysql.tablespace.type.ByteArr;

public class HandlerClassNotFoundException extends RuntimeException {
    public HandlerClassNotFoundException(ByteArr pageType) {
        super("注册的页类型中，找不到type="+pageType);
    }
}

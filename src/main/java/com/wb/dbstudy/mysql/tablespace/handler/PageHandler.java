package com.wb.dbstudy.mysql.tablespace.handler;

import com.wb.dbstudy.mysql.tablespace.bean.Page;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;

/**
 * @author wangbin
 * @version v1.0.0
 * @title PageHandler
 * @description 页处理器
 * @email wangbin69@guazi.com
 * @date 2021/10/24 10:50 上午
 */
public interface PageHandler<T extends Page> {
    /**
     * 解析数据
     * @param data
     * @return
     */
    T parse(byte[] data);

    /**
     * 页类型
     * @return
     */
    ByteArr type();
}

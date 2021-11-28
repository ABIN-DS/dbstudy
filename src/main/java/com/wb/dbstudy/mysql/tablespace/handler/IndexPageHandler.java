package com.wb.dbstudy.mysql.tablespace.handler;

import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;
import com.wb.dbstudy.mysql.tablespace.bean.Index;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;

/**
 * @author wangbin
 * @version v1.0.0
 * @title IndexPageHandler
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 11:00 上午
 */
public class IndexPageHandler implements PageHandler<Index> {
    @Override
    public Index parse(byte[] data) {
        return new Index(data);
    }

    @Override
    public ByteArr type() {
        return FileHeader.FILE_PAGE_INDEX;
    }
}

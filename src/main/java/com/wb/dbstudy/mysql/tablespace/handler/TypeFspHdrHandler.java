package com.wb.dbstudy.mysql.tablespace.handler;

import com.wb.dbstudy.mysql.tablespace.bean.TypeFspHdr;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;

/**
 * @author wangbin
 * @version v1.0.0
 * @title IndexPageHandler
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 11:00 上午
 */
public class TypeFspHdrHandler implements PageHandler<TypeFspHdr> {
    @Override
    public TypeFspHdr parse(byte[] data) {
        System.out.println("parse typefsphdr");
        return new TypeFspHdr(data);
    }

    @Override
    public int type() {
        return FileHeader.FILE_PAGE_TYPE_FSP_HEDR;
    }
}

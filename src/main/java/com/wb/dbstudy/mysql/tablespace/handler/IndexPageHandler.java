package com.wb.dbstudy.mysql.tablespace.handler;

import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;
import com.wb.dbstudy.mysql.tablespace.bean.IndexPage;

/**
 * @author wangbin
 * @version v1.0.0
 * @title IndexPageHandler
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 11:00 上午
 */
public class IndexPageHandler implements PageHandler<IndexPage> {
    @Override
    public IndexPage parse(byte[] data) {
        System.out.println("parse IndexPage");
        return new IndexPage(data);
    }

    @Override
    public int type() {
        return FileHeader.FILE_PAGE_INDEX;
    }
}

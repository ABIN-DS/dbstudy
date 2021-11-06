package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.EmptySpace;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.FileSpaceHeader;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.XDESEntry;
import com.wb.dbstudy.mysql.tablespace.beanfactory.BasicBeanFactory;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangbin
 * @version v1.0.0
 * @title TypeFspHdr
 * @description Type fsp hdr类型页面
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:45 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TypeFspHdr extends Page{
    FileSpaceHeader fileSpaceHeader;
    XDESEntry[] xdesEntryArr;
    EmptySpace emptySpace;

    public TypeFspHdr(byte[] data) {
        super(data);
        this.fileSpaceHeader = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 38, 38+112), FileSpaceHeader.class);

    }
}

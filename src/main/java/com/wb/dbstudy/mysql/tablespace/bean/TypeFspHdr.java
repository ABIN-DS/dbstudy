package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.EmptySpace;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.FileSpaceHeader;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.XDESEntry;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title TypeFspHdr
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:45 下午
 */
@Data
public class TypeFspHdr extends Page{
    FileSpaceHeader fileSpaceHeader;
    XDESEntry[] xdesEntryArr;
    EmptySpace emptySpace;

    public TypeFspHdr(byte[] data) {
        super(data);
        this.fileSpaceHeader = new FileSpaceHeader(ArrayUtil.sub(data, 38, 38+112));
    }
}

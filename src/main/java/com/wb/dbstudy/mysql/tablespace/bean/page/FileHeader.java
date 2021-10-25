package com.wb.dbstudy.mysql.tablespace.bean.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.impl.BeanConverter;
import cn.hutool.core.util.HexUtil;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title FileHeader
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 9:14 上午
 */
@Data
public class FileHeader {
    public static final int FILE_PAGE_INDEX = HexUtil.hexToInt("45BF");
    public static final int FILE_PAGE_TYPE_FSP_HEDR = HexUtil.hexToInt("0008");

    private int spaceOrChksum;
    private int offset;
    private int prev;
    private int next;
    private long lsn;
    private int type;
    private long fileFlushLsn;
    private int archLogNoOrSpaceId;

    public FileHeader(byte[] data) {
        this.spaceOrChksum = ToolByteArray.getInt(data, 0, 4);
        this.offset = ToolByteArray.getInt(data, 4, 4);
        this.prev = ToolByteArray.getInt(data, 8, 4);
        this.next = ToolByteArray.getInt(data, 12, 4);
        this.lsn = ToolByteArray.getLong(data, 16, 8);
        this.type = ToolByteArray.getInt(data, 24, 2);
        this.fileFlushLsn = ToolByteArray.getLong(data, 26, 8);
        this.archLogNoOrSpaceId = ToolByteArray.getInt(data, 34, 4);
    }
}

package com.wb.dbstudy.mysql.tablespace.bean.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.impl.BeanConverter;
import cn.hutool.core.util.HexUtil;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
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

    private ByteArr spaceOrChksum;
    private ByteArr offset;
    private ByteArr prev;
    private ByteArr next;
    private ByteArr lsn;
    private ByteArr type;
    private ByteArr fileFlushLsn;
    private ByteArr archLogNoOrSpaceId;

    public FileHeader(byte[] data) {
        this.spaceOrChksum = new ByteArr(data, 0, 4);
        this.offset = new ByteArr(data, 4, 4);
        this.prev = new ByteArr(data, 8, 4);
        this.next = new ByteArr(data, 12, 4);
        this.lsn = new ByteArr(data, 16, 8);
        this.type = new ByteArr(data, 24, 2);
        this.fileFlushLsn = new ByteArr(data, 26, 8);
        this.archLogNoOrSpaceId = new ByteArr(data, 34, 4);
    }
}

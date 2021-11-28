package com.wb.dbstudy.mysql.tablespace.bean.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.impl.BeanConverter;
import cn.hutool.core.util.HexUtil;
import com.wb.dbstudy.mysql.tablespace.bean.*;
import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
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
public class FileHeader implements ByteAllocate {
    public static final ByteArr FILE_PAGE_TYPE_ALLOCATED = new ByteArr(HexUtil.decodeHex("0000"));
    public static final ByteArr FILE_PAGE_UNDO_LOG = new ByteArr(HexUtil.decodeHex("0002"));
    public static final ByteArr FILE_PAGE_INODE = new ByteArr(HexUtil.decodeHex("0003"));
    public static final ByteArr FILE_PAGE_IBUF_FREE_LIST = new ByteArr(HexUtil.decodeHex("0004"));
    public static final ByteArr FILE_PAGE_IBUF_BITMAP = new ByteArr(HexUtil.decodeHex("0005"));
    public static final ByteArr FILE_PAGE_TYPE_SYS = new ByteArr(HexUtil.decodeHex("0006"));
    public static final ByteArr FILE_PAGE_TYPE_TRX_SYS = new ByteArr(HexUtil.decodeHex("0007"));
    public static final ByteArr FILE_PAGE_TYPE_FSP_HEDR = new ByteArr(HexUtil.decodeHex("0008"));
    public static final ByteArr FILE_PAGE_TYPE_XDES = new ByteArr(HexUtil.decodeHex("0009"));
    public static final ByteArr FILE_PAGE_TYPE_BLOB = new ByteArr(HexUtil.decodeHex("000A"));
    public static final ByteArr FILE_PAGE_INDEX = new ByteArr(HexUtil.decodeHex("45BF"));

    private ByteArr spaceOrChksum;
    private ByteArr offset;
    private ByteArr prev;
    private ByteArr next;
    private ByteArr lsn;
    private ByteArr type;
    private ByteArr fileFlushLsn;
    private ByteArr archLogNoOrSpaceId;

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 4, 4, 4, 8, 2, 8, 4};
    }
}

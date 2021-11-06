package com.wb.dbstudy.mysql.tablespace.bean.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.impl.BeanConverter;
import cn.hutool.core.util.HexUtil;
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

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 4, 4, 4, 8, 2, 8, 4};
    }
}

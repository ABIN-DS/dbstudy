package com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.filespaceheader;

import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title ListBaseNode
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:59 下午
 */
@Data
public class ListBaseNode implements ByteAllocate {
    ByteArr listLength;
    ByteArr firstNodePageNumber;
    ByteArr firstNodeOffset;
    ByteArr lastNodePageNumber;
    ByteArr lastNodeOffset;

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 4, 2, 4, 2};
    }
}

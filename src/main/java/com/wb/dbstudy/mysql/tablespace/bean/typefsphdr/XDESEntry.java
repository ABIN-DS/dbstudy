package com.wb.dbstudy.mysql.tablespace.bean.typefsphdr;

import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.xdesentry.ListNode;
import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title XDESEntry
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:51 下午
 */
@Data
public class XDESEntry implements ByteAllocate {
    ByteArr segmentID;
    ListNode listNode;
    ByteArr state;
    ByteArr pageStateBitmap;

    @Override
    public int[] getAllocateArr() {
        return new int[]{8, 12, 4, 16};
    }
}

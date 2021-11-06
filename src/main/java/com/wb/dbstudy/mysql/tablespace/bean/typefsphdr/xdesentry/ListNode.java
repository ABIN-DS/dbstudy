package com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.xdesentry;

import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title ListNode
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/30 1:57 下午
 */
@Data
public class ListNode implements ByteAllocate{
    ByteArr prevNodePageNumber;
    ByteArr prevNodeOffset;
    ByteArr nextNodePageNumber;
    ByteArr nextNodeOffset;

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 2, 4, 2};
    }
}

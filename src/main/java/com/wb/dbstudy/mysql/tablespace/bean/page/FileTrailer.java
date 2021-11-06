package com.wb.dbstudy.mysql.tablespace.bean.page;

import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title FileTrailer
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 9:17 上午
 */
@Data
public class FileTrailer implements ByteAllocate {
    private ByteArr chksum;
    private ByteArr lsn;

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 4};
    }
}

package com.wb.dbstudy.mysql.tablespace.bean.typefsphdr;

import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.filespaceheader.ListBaseNode;
import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title FileSpaceHeader
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:51 下午
 */
@Data
public class FileSpaceHeader implements ByteAllocate {
    ByteArr spaceId;
    ByteArr notUsed;
    ByteArr size;
    ByteArr freeLimit;
    ByteArr spaceFlags;
    ByteArr fragNUsed;
    ListBaseNode freeList;
    ListBaseNode freeFragList;
    ListBaseNode fullFragList;
    ByteArr nextUnusedSegmentId;
    ListBaseNode segInodesFullList;
    ListBaseNode segInodesFreeList;

    public FileSpaceHeader(){}

    @Override
    public int[] getAllocateArr() {
        return new int[]{4, 4, 4, 4, 4, 4, 16, 16, 16, 8, 16, 16};
    }
}

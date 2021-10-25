package com.wb.dbstudy.mysql.tablespace.bean.typefsphdr;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.filespaceheader.ListBaseNode;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;
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
public class FileSpaceHeader {
    int spaceId;
    int notUsed;
    int size;
    int freeLimit;
    int spaceFlags;
    int fragNUsed;
    ListBaseNode freeList;
    ListBaseNode freeFragList;
    ListBaseNode fullFragList;
    long nextUnusedSegmentId;
    ListBaseNode segInodesFullList;
    ListBaseNode segInodesFreeList;

    public FileSpaceHeader(byte[] data) {
        this.spaceId = ToolByteArray.getInt(data, 0, 4);
        this.notUsed = ToolByteArray.getInt(data, 4, 4);
        this.size = ToolByteArray.getInt(data, 8, 4);
        this.freeLimit = ToolByteArray.getInt(data, 12, 4);
        this.spaceFlags = ToolByteArray.getInt(data, 16, 4);
        this.fragNUsed = ToolByteArray.getInt(data, 20, 4);
        this.freeList = new ListBaseNode(ArrayUtil.sub(data, 24, 16));
        this.freeFragList = new ListBaseNode(ArrayUtil.sub(data, 40, 16));
        this.fullFragList = new ListBaseNode(ArrayUtil.sub(data, 56, 16));
        this.nextUnusedSegmentId = ToolByteArray.getLong(data, 72, 8);
        this.segInodesFullList = new ListBaseNode(ArrayUtil.sub(data, 80, 16));
        this.segInodesFreeList = new ListBaseNode(ArrayUtil.sub(data, 96, 16));
    }
}

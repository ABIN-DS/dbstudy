package com.wb.dbstudy.mysql.tablespace.bean.inode;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.inode.fragmentarrayentry.FragmentArrayEntry;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.filespaceheader.ListBaseNode;
import com.wb.dbstudy.mysql.tablespace.beanfactory.BasicBeanFactory;
import com.wb.dbstudy.mysql.tablespace.beanfactory.ByteAllocate;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

import java.util.List;

@Data
public class INodeEntry {
    ByteArr segmentId;
    ListBaseNode freeList;
    ListBaseNode notFullList;
    ListBaseNode fullList;
    ByteArr magicNumber;
    FragmentArrayEntry[] fragmentArrayEntrieArr;

    public INodeEntry(byte[] data){
        this.segmentId = new ByteArr(ArrayUtil.sub(data, 0, 8));
        this.freeList = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 8, 8+16), ListBaseNode.class);
        this.notFullList = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 8+16, 8+32), ListBaseNode.class);
        this.fullList = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 8+32, 8+48), ListBaseNode.class);
        this.magicNumber = new ByteArr(ArrayUtil.sub(data, 56, 4));
        int fragmentCount = 32;
        this.fragmentArrayEntrieArr = new FragmentArrayEntry[fragmentCount];
        for(int i=0; i<fragmentCount; ++i){
            this.fragmentArrayEntrieArr[i] = new FragmentArrayEntry(ArrayUtil.sub(data, 60+i*4, 60+(i+1)*4));
        }
    }
}

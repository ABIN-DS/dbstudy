package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.inode.INodeEntry;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.FileSpaceHeader;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.xdesentry.ListNode;
import com.wb.dbstudy.mysql.tablespace.beanfactory.BasicBeanFactory;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class INode extends Page{
    ListNode iNodePageList;
    INodeEntry[] entryArr;
    ByteArr emptySpace;

    public INode(byte[] data){
        super(data);
        this.iNodePageList = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 38, 38+12), ListNode.class);
        int iNodeEntryCount = 85;
        this.entryArr = new INodeEntry[iNodeEntryCount];
        for(int i=0; i<iNodeEntryCount; ++i){
            this.entryArr[i] = new INodeEntry(ArrayUtil.sub(data, 50+i*192,  50+(i+1)*192));
        }
        this.emptySpace = new ByteArr(ArrayUtil.sub(data, 16370, 16376));
    }
}

package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.FileSpaceHeader;
import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.XDESEntry;
import com.wb.dbstudy.mysql.tablespace.beanfactory.BasicBeanFactory;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbin
 * @version v1.0.0
 * @title TypeFspHdr
 * @description Type fsp hdr类型页面
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:45 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TypeFspHdr extends Page{
    FileSpaceHeader fileSpaceHeader;
    XDESEntry[] xdesEntryArr;
    ByteArr emptySpace;

    public TypeFspHdr(byte[] data) {
        super(data);
        this.fileSpaceHeader = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 38, 38+112), FileSpaceHeader.class);

        //解析数组
        int startIndex = 38+112;
        List<XDESEntry> xdesEntryList = new ArrayList<XDESEntry>();
        while(startIndex < 16376){
            byte[] tempXdesData = ArrayUtil.sub(data, startIndex, startIndex+40);
            if(ToolByteArray.isEmpth(tempXdesData)){
                break;
            }else {
                ++startIndex;
                xdesEntryList.add(BasicBeanFactory.createBeanByAllocate(tempXdesData, XDESEntry.class));
            }
        }
        xdesEntryArr = new XDESEntry[xdesEntryList.size()];
        xdesEntryList.toArray(xdesEntryArr);

        this.emptySpace = new ByteArr(data, startIndex, 16376);
    }
}

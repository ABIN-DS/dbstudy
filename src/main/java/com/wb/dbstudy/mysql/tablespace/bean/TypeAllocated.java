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
public class TypeAllocated extends Page{
    ByteArr data;

    public TypeAllocated(byte[] data){
        super(data);
        this.data = new ByteArr(data, 38, 16338);
    }
}

package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileTrailer;
import com.wb.dbstudy.mysql.tablespace.beanfactory.BasicBeanFactory;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title Page
 * @description 公共页头页尾
 * @email wangbin69@guazi.com
 * @date 2021/10/24 10:48 上午
 */
@Data
public class Page {
    FileHeader fileHeader;
    FileTrailer fileTrailer;

    public Page(){}

    public Page(byte[] data){
        this.fileHeader = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 0, 38), FileHeader.class);
        this.fileTrailer = BasicBeanFactory.createBeanByAllocate(ArrayUtil.sub(data, 16*1024-8, 16*1024), FileTrailer.class);
    }
}

package com.wb.dbstudy.mysql.tablespace.bean;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileTrailer;
import lombok.Data;

/**
 * @author wangbin
 * @version v1.0.0
 * @title Page
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 10:48 上午
 */
@Data
public class Page {
    FileHeader fileHeader;
    FileTrailer fileTrailer;

    public Page(){}

    public Page(byte[] data){
        this.fileHeader = new FileHeader(ArrayUtil.sub(data, 0, 38));
    }
}

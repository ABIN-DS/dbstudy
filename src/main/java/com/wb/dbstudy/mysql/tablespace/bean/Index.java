package com.wb.dbstudy.mysql.tablespace.bean;

import com.wb.dbstudy.mysql.tablespace.bean.index.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangbin
 * @version v1.0.0
 * @title Page
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 9:09 上午
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Index extends Page{
    PageHeader pageHeader;
    Infimum infimum;
    Supremum supremum;
    UserRecords userRecords;
    FreeSpace freeSpace;
    PageDirectory pageDirectory;

    public Index(byte[] data){
        super(data);
    }
}

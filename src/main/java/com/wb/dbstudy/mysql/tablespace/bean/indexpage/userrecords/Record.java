package com.wb.dbstudy.mysql.tablespace.bean.indexpage.userrecords;

/**
 * @author wangbin
 * @version v1.0.0
 * @title Record
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 9:20 上午
 */
public class Record {
    DynamicLenthData dynamicLenthData;
    NullValueData nullValueData;
    RecordHeaderData recordHeaderData;
    PrimaryKeyValue primaryKeyValue;
    TrxIdValue trxIdValue;
    RollPointerValue rollPointerValue;
    ColumnValueData columnValueData;
}

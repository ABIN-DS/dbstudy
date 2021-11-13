package com.wb.dbstudy.mysql.tablespace.bean;

import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class INode extends Page{
    ByteArr data;

    public INode(byte[] data){
        super(data);
        this.data = new ByteArr(data, 38, 16338);
    }
}

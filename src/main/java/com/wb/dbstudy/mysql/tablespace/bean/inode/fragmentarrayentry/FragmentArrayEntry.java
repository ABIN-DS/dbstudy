package com.wb.dbstudy.mysql.tablespace.bean.inode.fragmentarrayentry;

import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import lombok.Data;

@Data
public class FragmentArrayEntry {
    ByteArr data;

    public FragmentArrayEntry(byte[] data){
        this.data = new ByteArr(data);
    }
}

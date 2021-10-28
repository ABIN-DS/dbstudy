package com.wb.dbstudy.mysql.tablespace.type;

import cn.hutool.core.convert.Convert;
import lombok.Data;
import cn.hutool.core.util.ArrayUtil;

@Data
public class ByteArr {
    private byte[] data;

    public ByteArr(byte[] source, int startIndex, int byteCount){
        data = ArrayUtil.sub(source, startIndex, startIndex+byteCount);
    }

    @Override
    public String toString(){
        return Convert.toHex(data);
    }
}

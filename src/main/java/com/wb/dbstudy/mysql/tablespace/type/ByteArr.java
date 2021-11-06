package com.wb.dbstudy.mysql.tablespace.type;

import cn.hutool.core.convert.Convert;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;
import lombok.Data;
import cn.hutool.core.util.ArrayUtil;

@Data
public class ByteArr {
    private byte[] data;

    public ByteArr(byte[] source, int startIndex, int byteCount){
        data = ArrayUtil.sub(source, startIndex, startIndex+byteCount);
    }

    public ByteArr(byte[] source, int[] byteAllocate, int index){
        data = ToolByteArray.getByteDataBySum(source, byteAllocate, index);
    }

    @Override
    public String toString(){
        return Convert.toHex(data);
    }
}

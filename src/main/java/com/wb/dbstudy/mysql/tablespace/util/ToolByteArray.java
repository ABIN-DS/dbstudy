package com.wb.dbstudy.mysql.tablespace.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;

/**
 * @author wangbin
 * @version v1.0.0
 * @title ToolByteArray
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 5:25 下午
 */
public class ToolByteArray {
    private static final int COUNT_BYTE_TO_INT = 4;
    public static int getInt(byte[] data, int startIndex, int byteCount){
        if(byteCount > COUNT_BYTE_TO_INT || byteCount < 0){
            throw new RuntimeException("byteCount out of range");
        }
        byte[] convertByte = new byte[COUNT_BYTE_TO_INT];
        int copyCount = 0;
        for(int i=COUNT_BYTE_TO_INT-byteCount; i<COUNT_BYTE_TO_INT; ++i){
            convertByte[i] = data[startIndex+copyCount];
            ++copyCount;
        }
        String hexStr = Convert.toHex(convertByte);
        if(hexStr.startsWith("f")){
            return 0;
        }
        return Integer.parseInt(hexStr, 16);
    }

    private static final int COUNT_BYTE_TO_LONG = 8;
    public static long getLong(byte[] data, int startIndex, int byteCount) {
        if(byteCount > COUNT_BYTE_TO_LONG || byteCount < 0){
            throw new RuntimeException("byteCount out of range");
        }
        byte[] covertByte = new byte[COUNT_BYTE_TO_LONG];
        int copyCount = 0;
        for(int i=COUNT_BYTE_TO_LONG-byteCount; i<COUNT_BYTE_TO_LONG; ++i){
            covertByte[i] = data[startIndex+copyCount];
            ++copyCount;
        }
        return Convert.bytesToLong(covertByte);
    }
}

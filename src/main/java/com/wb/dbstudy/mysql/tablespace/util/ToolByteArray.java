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
    public static byte[] getByteDataBySum(byte[] source, int[] byteAllocate, int index) {
        int startIndex = 0;
        int byteCount = byteAllocate[index];
        for(int i=0; i<index; ++i){
            startIndex += byteAllocate[i];
        }
        return ArrayUtil.sub(source, startIndex, startIndex+byteCount);
    }

    public static boolean isEmpth(byte[] source){
        for(byte temp: source){
            if(temp != 0){
                return false;
            }
        }
        return true;
    }
}

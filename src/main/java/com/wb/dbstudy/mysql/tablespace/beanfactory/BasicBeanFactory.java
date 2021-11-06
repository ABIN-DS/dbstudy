package com.wb.dbstudy.mysql.tablespace.beanfactory;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;

import java.lang.reflect.Field;

/**
 * @author wangbin
 * @version v1.0.0
 * @title BeanFactory
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/30 11:23 上午
 */
public class BasicBeanFactory {
    public static <T extends ByteAllocate> T createBeanByAllocate(byte[] data, Class<T> clazz){
        Field[] clazzField = clazz.getDeclaredFields();
        T tInstance = null;
        try {
            tInstance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            int[] byteAllocateArr = tInstance.getAllocateArr();
            int allocateIndex = 0;
            for(int i=0; i<clazzField.length; ++i){
                Field field = clazzField[i];
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                if(ByteArr.class.isAssignableFrom(field.getType())){
                    field.set(tInstance, new ByteArr(data, byteAllocateArr, allocateIndex));
                    ++allocateIndex;
                }else if( ByteAllocate.class.isAssignableFrom(field.getType())){
                    field.set(tInstance, createBeanByAllocate(ToolByteArray.getByteDataBySum(data, byteAllocateArr, allocateIndex), (Class<ByteAllocate>) field.getType()));
                    ++allocateIndex;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return tInstance;
    }
}

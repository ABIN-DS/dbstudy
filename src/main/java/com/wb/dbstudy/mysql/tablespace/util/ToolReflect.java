package com.wb.dbstudy.mysql.tablespace.util;

import com.wb.dbstudy.mysql.tablespace.handler.IndexPageHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbin
 * @version v1.0.0
 * @title ReflectUtil
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 4:18 下午
 */
public class ToolReflect {
    private static List<Class> getAllImplClass(String classPath, Class clazz){
        List<Class> data = new ArrayList<Class>(){{
            add(IndexPageHandler.class);
        }};
        return data;
    }

    public static List<Class> getAllImplClass(Class clazz){
        String path = getClassPath(clazz);
        return getAllImplClass(path, clazz);
    }

    private static String getClassPath(Class clazz){
        return "";
    }
}

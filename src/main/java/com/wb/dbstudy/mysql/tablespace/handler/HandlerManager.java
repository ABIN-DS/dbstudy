package com.wb.dbstudy.mysql.tablespace.handler;

import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.Page;
import com.wb.dbstudy.mysql.tablespace.exception.HandlerNotFoundException;
import com.wb.dbstudy.mysql.tablespace.util.ToolReflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangbin
 * @version v1.0.0
 * @title HandlerController
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 10:58 上午
 */
public class HandlerManager {
    private static Map<Class<? extends Page>, PageHandler> registryHandler = new HashMap<Class<? extends Page>, PageHandler>(){{
        List<Class> subClassList = ToolReflect.getAllImplClass(PageHandler.class);
        for(Class item: subClassList){
            Class<PageHandler> itemC = (Class<PageHandler>) item;
            Type[] interfaceType = itemC.getGenericInterfaces();
            if(interfaceType == null
                    || interfaceType.length == 0
                    || !(interfaceType[0] instanceof ParameterizedType)){
                continue;
            }
            ParameterizedType paramType = (ParameterizedType) interfaceType[0];
            Type[] interfaceTypeParamType = paramType.getActualTypeArguments();
            if(interfaceTypeParamType == null
                    || interfaceTypeParamType.length == 0){
                continue;
            }
            try {
                put((Class<Page>)interfaceTypeParamType[0], itemC.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }};

    public static <T extends Page> T doHandle(byte[] data, Class<T> clazz) {
        PageHandler handler = registryHandler.get(clazz);
        if (handler == null) {
            throw new HandlerNotFoundException(clazz);
        }
        return (T) handler.parse(ArrayUtil.sub(data, 38, data.length));
    }
}

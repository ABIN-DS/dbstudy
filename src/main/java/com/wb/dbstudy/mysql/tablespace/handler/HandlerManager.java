package com.wb.dbstudy.mysql.tablespace.handler;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;
import com.wb.dbstudy.mysql.tablespace.bean.*;
import com.wb.dbstudy.mysql.tablespace.bean.page.FileHeader;
import com.wb.dbstudy.mysql.tablespace.exception.HandlerByBeanConstructorException;
import com.wb.dbstudy.mysql.tablespace.exception.HandlerClassNotFoundException;
import com.wb.dbstudy.mysql.tablespace.exception.HandlerNotFoundException;
import com.wb.dbstudy.mysql.tablespace.type.ByteArr;
import com.wb.dbstudy.mysql.tablespace.util.ToolReflect;

import java.lang.reflect.Constructor;
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
    private static Map<ByteArr, Class<? extends Page>> registryClass = new HashMap<ByteArr, Class<? extends Page>>(){{
        put(FileHeader.FILE_PAGE_TYPE_ALLOCATED, TypeAllocated.class);
        put(FileHeader.FILE_PAGE_UNDO_LOG, UndoLog.class);
        put(FileHeader.FILE_PAGE_INODE, INode.class);
        put(FileHeader.FILE_PAGE_IBUF_FREE_LIST, IBufFreeList.class);
        put(FileHeader.FILE_PAGE_IBUF_BITMAP, IBufBitmap.class);
        put(FileHeader.FILE_PAGE_TYPE_SYS, TypeSys.class);
        put(FileHeader.FILE_PAGE_TYPE_TRX_SYS, TypeTrxSys.class);
        put(FileHeader.FILE_PAGE_TYPE_FSP_HEDR, TypeFspHdr.class);
        put(FileHeader.FILE_PAGE_TYPE_XDES, TypeXDES.class);
        put(FileHeader.FILE_PAGE_TYPE_BLOB, TypeBlob.class);
        put(FileHeader.FILE_PAGE_INDEX, Index.class);
    }};

    public static <T extends Page> T doHandle(byte[] data, Class<T> clazz) {
        PageHandler handler = registryHandler.get(clazz);
        if (handler == null) {
            return parseByConstructor(data, clazz);
        }
        return (T) handler.parse(data);
    }

    private static <T extends Page> T parseByConstructor(byte[] data, Class<T> tClazz) {
        try {
            return (T) tClazz.getConstructor(byte[].class).newInstance(data);
        } catch (Exception e) {
            throw new HandlerByBeanConstructorException(e);
        }
    }

    public static Class<? extends Page> getClass(byte[] data){
        ByteArr pageType = new ByteArr(ArrayUtil.sub(data, 24, 26));
        if(registryClass.containsKey(pageType)){
            return registryClass.get(pageType);
        }else{
            throw new HandlerClassNotFoundException(pageType);
        }
    }
}

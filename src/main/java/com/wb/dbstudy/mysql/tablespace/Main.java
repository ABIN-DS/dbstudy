package com.wb.dbstudy.mysql.tablespace;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import com.wb.dbstudy.mysql.tablespace.bean.IndexPage;
import com.wb.dbstudy.mysql.tablespace.bean.TypeFspHdr;
import com.wb.dbstudy.mysql.tablespace.handler.HandlerManager;
import com.wb.dbstudy.mysql.tablespace.util.ToolByteArray;

import java.io.File;
import java.net.URL;

/**
 * @author wangbin
 * @version v1.0.0
 * @title Main
 * @description TODO
 * @email wangbin69@guazi.com
 * @date 2021/10/24 9:08 上午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=======start=========");
        try{
            testDemo();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("=======end=========");
    }

    private static void testDemo() {
        //加载文件为byte array
        URL url = Main.class.getClassLoader().getResource("");
        String classpath = url.getPath();
        String dbStudy = classpath.substring(0, classpath.lastIndexOf("dbstudy")+7);
        byte[] data = FileUtil.readBytes(new File(dbStudy+"/data/demo.ibd"));

        System.out.println("demo byte.len="+data.length+",size/16kb="+(data.length/(16*1024)));

        //解析TYPE FSP HDR页面
        for(int i=0; i<6; ++i){
            byte[] innerData = ArrayUtil.sub(data, i*16*1024, (i+1)*16*1024);
            TypeFspHdr typeFspHdr = HandlerManager.doHandle(innerData, TypeFspHdr.class);
            System.out.println(typeFspHdr.getFileHeader().toString());
            if(i == 0)System.out.println(typeFspHdr.getFileSpaceHeader().toString());
        }
    }

}

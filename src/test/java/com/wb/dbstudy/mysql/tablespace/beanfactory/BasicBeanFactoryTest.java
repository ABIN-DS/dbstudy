package com.wb.dbstudy.mysql.tablespace.beanfactory;

import com.wb.dbstudy.mysql.tablespace.bean.typefsphdr.filespaceheader.ListBaseNode;
import org.junit.jupiter.api.Test;

class BasicBeanFactoryTest {

    @Test
    void createBeanByAllocate() {
        byte data[] = new byte[]{
                0,0,0,4,
                0,0,0,1,
                0,0,
                0,0,0,4,
                0,4
            };
        BasicBeanFactory bf = new BasicBeanFactory();
        ListBaseNode node = bf.createBeanByAllocate(data, ListBaseNode.class);
        System.out.println(node.toString());
    }
}
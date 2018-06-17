package com.anarchy.classifyview.utils;

import com.anarchy.classifyview.core.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * User:  Anarchy
 * Email:  rsshinide38@163.com
 * CreateTime: 十二月/25/2016  11:57.
 * Description:
 */

public class DataGenerate {
    public static List<List<Bean>> generateBean() {
        List<List<Bean>> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            List<Bean> inner = new ArrayList<>();
            if (i > 10) {
                int c = (int) (Math.random() * 15 + 1);
                for (int j = 0; j < c; j++) {
                    Bean e = new Bean();
                    e.setFolder(true);
                    e.setName("应用"+i + "-" + j);
                    e.setFolderName("文件夹"+i);
                    inner.add(e);
                }
            } else {
                Bean b = new Bean();
                b.setFolder(false);
                b.setName("应用"+i);
                inner.add(b);
            }
            data.add(inner);
        }
        return data;
    }
//    public static List<BaseBean> generateBaseBean(){
//        List<BaseBean> data = new ArrayList<>();
//        for(int i=0;i<6;i++){
//            BaseBean baseBean=new BaseBean();
//            List<BookBean> inner = new ArrayList<>();
//            inner.add(new BookBean());
//
//            baseBean.setBookList(inner);
//            data.add(baseBean);
//        }
//        return data;
//    }
}

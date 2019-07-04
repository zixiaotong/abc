package com.abc.design.observer.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 17:20
 **/
public class WriterManager {
    private Map<String, Writer> writerMap = new HashMap<>();

    //添加作者
    public void add(Writer writer){
        writerMap.put(writer.getName(), writer);
    }
    //根据作者姓名获取作者
    public Writer getWriter(String name){
        return writerMap.get(name);
    }

    //单例
    private WriterManager(){}

    private static class WriterManagerInstance{
        private static WriterManager instance = new WriterManager();
    }

    public static WriterManager getInstance(){
        return WriterManagerInstance.instance;
    }

}

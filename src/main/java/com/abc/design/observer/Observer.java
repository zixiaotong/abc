package com.abc.design.observer;

/**
 * 这个接口是为了提供一个统一的观察者做出相应行为的方法
 *
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 16:11
 **/
public interface Observer {
    /**
     * update
     *
     * @param o
     */
    void update(Observable o);
}

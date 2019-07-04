package com.abc.design.observer;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 16:13
 **/
public class ConcreteObserver2 implements Observer {

    @Override
    public void update(Observable o) {
        System.out.println("观察者2观察到" + o.getClass().getSimpleName() + "发生变化");
        System.out.println("观察者2做出相应");
    }
}

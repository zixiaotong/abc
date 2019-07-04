package com.abc.design.observer;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 16:12
 **/
public class ConcreteObserver1 implements Observer {
    @Override
    public void update(Observable o) {
        System.out.println("观察者1观察到" + o.getClass().getSimpleName() + "发生变化");
        System.out.println("观察者1做出相应");
    }
}

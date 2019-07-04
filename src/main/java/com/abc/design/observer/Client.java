package com.abc.design.observer;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 16:14
 **/
public class Client {
    public static void main(String[] args) {
        Observable observable = new Observable();
        observable.addObserver(new ConcreteObserver1());
        observable.addObserver(new ConcreteObserver2());

        observable.changed();
    }
}

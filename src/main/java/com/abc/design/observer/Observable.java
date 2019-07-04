package com.abc.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-04 16:12
 **/
public class Observable {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void changed() {
        System.out.println("我是被观察者，我已经发生变化了");
        //通知观察自己的所有观察者
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

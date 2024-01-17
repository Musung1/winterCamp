package com.thc.sprapi.config;

public class MySingleton implements MyInterface{
    static public MySingleton getInstance() {
        return new MySingleton();
    }
    private MySingleton() {
    }
    @Override
    public void hello() {
        System.out.println("hello");
    }
}

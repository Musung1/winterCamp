package com.thc.sprapi.config;

public class MyTest {
    MyInterface mySingleton;
    public MyTest(MyInterface mySingleton) {
        this.mySingleton = mySingleton;
    }
    public void start() {
        mySingleton.hello();
    }
}

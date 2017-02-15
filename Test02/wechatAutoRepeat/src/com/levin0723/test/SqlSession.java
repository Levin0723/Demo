package com.levin0723.test;


import java.lang.reflect.Proxy;

public class SqlSession {
    public <T> T getHandler(Class<T> type){
        System.out.println("SqlSession-->getHandler:"+"代理类生成实例返回");
        return (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MyInvocationHandler());
    }
}

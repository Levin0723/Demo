package com.levin0723.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler-->className:"+proxy.getClass().getName());
        System.out.println("MyInvocationHandler-->methodName:"+method.getName());
        return "invoke object";
    }
}

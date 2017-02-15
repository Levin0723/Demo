package com.levin0723.test;

public class MainTest {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        MyInterface myInterface = sqlSession.getHandler(MyInterface.class);
        String result = myInterface.getSomething(new Object());
        System.out.println(result);
    }


}

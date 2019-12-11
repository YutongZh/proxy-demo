package com.yt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPeople implements InvocationHandler {

    private Girl girl;

    public ProxyPeople(Girl girl) {
        this.girl = girl;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("增强前，王美丽父母说先调查下这个男孩的背景！");
        Object result = method.invoke(girl, args);
        System.out.println("增强后，王美丽的父母说这个男孩子有没有对你动手动脚");
        return result;
    }

    //获取代理对象
    public Object getInstance(){
        /**
         * loader: 用哪个类加载器去加载代理对象
         * interfaces:动态代理类需要实现的接口
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }


}

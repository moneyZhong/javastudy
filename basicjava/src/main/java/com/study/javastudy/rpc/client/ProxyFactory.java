package com.study.javastudy.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ProxyFactory {

    private Class target;

    public ProxyFactory(Class target){
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket=new Socket("127.0.0.1",8888);
                String className=target.getName();//api类名
                String  methodName=method.getName();//api 类成员方法名
                Class<?>[] parameterTypes=method.getParameterTypes(); //类成员方法参数类型集合

                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeUTF(className);
                objectOutputStream.writeUTF(methodName);
                objectOutputStream.writeObject(parameterTypes);
                objectOutputStream.writeObject(args);

                ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                Object o=objectInputStream.readObject();
                objectInputStream.close();
                objectOutputStream.close();
                return o;

            }
        });
    }
}

package com.study.javastudy.designpattern.myifelse.v2;

import com.study.javastudy.designpattern.myifelse.v1.ProductFactory;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * product 上下文
 *  存储从三方中获取的参数，避免多个规则调用时，都去三方获取数据
 */
public class ProductContext {
    private final static ThreadLocal<ProductContext> threadLocal = new ThreadLocal<>();
    private Worker worker;
    private Tool tool;



    public static Worker getWorker(){
        ProductContext productContext = threadLocal.get();
        if(productContext == null){
            return null;
        }else{
            return productContext.worker;
        }
    }

    public static Tool getTool(){
        ProductContext productContext = threadLocal.get();
        if(productContext == null){
            return null;
        }else{
            return productContext.tool;
        }
    }

    public static void setContextWorker(Worker work){
        ProductContext productContext = threadLocal.get();
        if(productContext == null){
            productContext = new ProductContext();
        }
        productContext.worker = work;
        threadLocal.set(productContext);
    }

    public static void setTool(Tool tool){
        ProductContext productContext = threadLocal.get();
        if(productContext == null){
            productContext = new ProductContext();
        }
        productContext.tool = tool;
        threadLocal.set(productContext);
    }

    public static void clear(){
        threadLocal.remove();
    }

    public static void main(String[] args) {
        Tool tool = ProductContext.getTool();
        System.out.println(tool);//null
        tool = new Tool();
        System.out.println(tool);//1
        System.out.println(ProductContext.getTool());//null
        ProductContext.setTool(tool);
        System.out.println(ProductContext.getTool());//1
        tool = new Tool();
        System.out.println(ProductContext.getTool());//1

        new Thread(()->{
            System.out.println(ProductContext.getTool());//null
        }).start();

    }

}

package com.study.javastudy;

import com.study.javastudy.designpattern.clone.DeepClone;
import com.study.javastudy.designpattern.clone.DeepObject;
import com.study.javastudy.designpattern.clone.SimpleClone;
import com.study.javastudy.designpattern.clone.SimpleObject;
import com.study.javastudy.designpattern.factory.simple.LoggerFactory;
import com.study.javastudy.designpattern.single.SingleInit;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

//@SpringBootTest
class JavastudyApplicationTests {

    @Test
    void testDeepClone() throws Exception{
        DeepClone deepClone = new DeepClone();
        deepClone.setName("zhongqian");

        DeepObject deepObject = new DeepObject();
        deepObject.setAddress("中国");
        DeepObject deepObject2 = new DeepObject();
        deepObject2.setAddress("三系");
        deepObject.setDeepObject(deepObject2);

        deepClone.setDeepObject(deepObject);

        System.out.println(deepClone);

        DeepClone de2 = deepClone.deepObject();

        System.out.println(deepClone);
        System.out.println(de2);

        deepObject.setAddress("苏州");
        System.out.println(deepClone);
        System.out.println(de2);




    }
    @Test
    void testClone() throws Exception{
        SimpleClone simpleClone = new SimpleClone();
        simpleClone.setAge(20);
        simpleClone.setName("zhongqina");

        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setAddress("背景");
        simpleClone.setSimpleObject(simpleObject);

        SimpleClone simpleClone1 = simpleClone.clone();
        simpleClone1.setAge(300);
        simpleClone1.getSimpleObject().setAddress("北京");
        System.out.println(simpleClone);
        System.out.println(simpleClone1);



        System.out.println(simpleClone == simpleClone1);
        System.out.println(simpleClone.getSimpleObject() == simpleClone1.getSimpleObject());

    }


    @Test
    void testSingle(){
        SingleInit sing = SingleInit.getInstance();
        SingleInit sing2 = SingleInit.getInstance();
        System.out.println(sing == sing2);
    }

    @Test
    void testFactory() {
        LoggerFactory loggerFactory =  (LoggerFactory) getBean();
        loggerFactory.writeLog();
    }
    public static Object getBean() {
        try {
            //创建DOM文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();

            //通过类名生成实例对象并将其返回
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

package com.study.javastudy.designpattern.clone;

import lombok.Data;
import lombok.ToString;

import java.io.*;

@Data
@ToString
public class DeepClone implements Serializable {
    private String name;
    private DeepObject deepObject;
    public DeepClone deepObject() throws  Exception{
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (DeepClone) objectInputStream.readObject();
    }
}

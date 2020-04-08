package com.study.javastudy.designpattern.clone;

import lombok.Data;

import java.io.*;

@Data
public class DeepObject implements Serializable {

    private String address;

    private DeepObject deepObject;


}

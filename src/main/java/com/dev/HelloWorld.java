package com.dev;

import org.data.*;
import org.springframework.util.StringUtils;

public class HelloWorld {

    private Data commonData = new CommonData();
    private Data inputData = new InputData();
    private Data outputData = new OutputData();


    public static void main(String[] args) {
        System.out.println(StringUtils.capitalize("hello world"));
    }
}

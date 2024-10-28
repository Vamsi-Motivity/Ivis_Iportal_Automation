package com.ivis.iportal.script;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

public class LoginValidation {
    static TestNG testng;



    public static void main(String[] args) {

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("./LoginValidation.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}


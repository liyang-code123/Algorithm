package javaregular;

import java.io.IOException;

public class TestException2 {
//    static void fun() throws IOException {
//        try {
//            throw new IOException("demo");
//            // unreachable statement int a = 1;
//        } catch(Exception e) {
//            System.out.println("Caught inside fun().");
//            throw e;
//        }
//    }
    static void fun() throws IllegalAccessException, IOException {
        System.out.println("Inside fun().");
        throw new IllegalAccessException("demo");
    }

    public static void main (String args[]) {
        try {
            fun();
        } catch(IOException | IllegalAccessException e) {
            System.out.println("Caught in main.");
        }

    }

}

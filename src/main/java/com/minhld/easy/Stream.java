package com.minhld.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream extends Thread {
    public void run() {

        flatMap();
        // filter();
        // join1();
    }

    private void flatMap() {
        String[][] a = new String[][] {
                { "hello", "minh" },
                { "address", "where" }
        };

        System.out.println(Arrays.stream(a)
                .flatMap(l -> Arrays.stream(l))
                .collect(Collectors.joining(" ")));
    }

    private void filter() {
        String[] a = new String[] { "hello", "my", "name", "is", "minh" };
        System.out.println(Arrays.stream(a)
                .filter(e -> e.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" ")));
    }

    private void join1() {
        String[] a = new String[] { "hello", "my", "name", "is", "minh" };
        // joining 1
        System.out.println(Arrays.stream(a)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" ", "[", "]")));
        // joining 2
        Arrays.stream(a)
                .map(String::toUpperCase)
                .forEach(e -> System.out.print(e + " "));
    }

    public static void main(String args[]) {
        new Stream().start();
    }
}

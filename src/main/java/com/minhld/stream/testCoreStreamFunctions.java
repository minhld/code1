package com.minhld.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.function.*;

public class testCoreStreamFunctions extends Thread {
    public void run() {
        // testSupplier();

        // Supplier<Integer> integerSupplier = getIntSupplier(3);
        // System.out.println("val = " + integerSupplier.get());

        // getNameFromStudent().accept("daniel");
        // concatenateGreeting().accept("hello", "daniel");
        // System.out.println("length = " + getTextLength().apply("hello"));
        System.out.println("length = " + getBiTextLength().apply("hello", "daniel"));
    }

    BiFunction<String, String, Integer> getBiTextLength() {
        return (s1, s2) -> s1.length() + s2.length();
    }

    Function<String, Integer> getTextLength() {
        return (s) -> s.length() + 1;
    }

    BiConsumer<String, String> concatenateGreeting() {
        return (s1, s2) -> System.out.println(s1 + " " + s2);
    }

    Supplier<Integer> getIntSupplier(int val) {
        return () -> val * 2;
    }

    Consumer<String> getNameFromStudent() {
        return (student) -> System.out.println("hello " + student);
    }

    void testSupplier() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };
        Arrays.stream(arrayOfEmps).forEach(this::getEmpName);
    }

    void getEmpName(Employee e) {
        System.out.println(e.getName());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee {
        int id;
        String name;
        double salary;
    }

    public static void main(String[] args) {
        new testCoreStreamFunctions().start();
    }
}

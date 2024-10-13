package com.minhld.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public class testSuppliers extends Thread {
    public void run() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };
        Arrays.asList(arrayOfEmps).stream().forEach(this::getEmpName);

    }

    void getEmpName(Employee e) {
        System.out.println(e.getName());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Employee {
        int id;
        String name;
        double salary;
    }

    public static void main(String[] args) {
        new testSuppliers().start();
    }
}

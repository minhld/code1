package com.minhld.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class test {
    public static void main(String args[]) {
        //testMap1();

    }

    private static void testSet1() {
        String test = "abcabcbb";
        Set<Character> set = test.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toSet());
    }

    private static void testMap1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        Optional<String> res = list.stream()
                .filter(e -> e.contains("j"))
                .map(e -> e.toUpperCase())
                .findFirst();
        System.out.println("res: " + res.get());
        list.stream()
                .collect(Collectors.toMap(e -> e, e -> e.length()))
                .forEach((k, v) -> System.out.println("k=" + k + ",v=" + v));
        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(e -> e, e -> e.length()));
    }
}

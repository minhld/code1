package com.minhld.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {
    public static void main(String args[]) {
        // testMap1();
        // testStringBuffer();
        testMaps();
    }

    private static void testMaps() {
        Set<Integer> set = Set.of(1, 3, 5, 7, 9);
        Map<Integer, Integer> map = set.stream().collect(Collectors.toMap(i -> i * 2, Function.identity(), (a1, a2) -> a1));
        set.stream().reduce(0, (n1, n2) -> n1 + n2,
        map.forEach((k, v) -> System.out.println("k = " + k + ", v = " + v));
    }

    private static void testStringBuffer() {
        int total = "delete".chars().reduce(0, Integer::sum);
        int[] a = new int[] { 2, 3, 5, 7 };
        int val = Arrays.stream(a).reduce(0, Integer::sum);
        System.out.println("val: " + total);
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

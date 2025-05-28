package com.minhld.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Utils {
    public static int[] readData(Class<?> parent) {
        String file = "sample.txt";
        String result = "";
        ClassLoader classLoader = parent.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(file)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + file);
            } else {
                result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            System.err.println("Exception " + e.getMessage());
        }
        return Arrays.stream(result.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}

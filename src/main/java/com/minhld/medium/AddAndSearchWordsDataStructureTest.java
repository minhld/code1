package com.minhld.medium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAndSearchWordsDataStructureTest {
    private static final Path LARGE_TEST_INPUT = Path.of("src/main/resources/add_and_search_words_large_test.txt");

    public static void main(String[] args) throws IOException {
        TestInput input = args.length == 0 ? defaultInput() : readInput(Path.of(args[0]));
        List<Boolean> results = run(input.operations, input.params);
        System.out.println(results);
        if (input.expected != null) {
            compare(results, input.expected);
        }
    }

    private static List<Boolean> run(String[] operations, String[][] params) {
        AddAndSearchWordsDataStructure wordDictionary = null;
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            if ("WordDictionary".equals(operation)) {
                wordDictionary = new AddAndSearchWordsDataStructure();
                results.add(null);
            } else if ("addWord".equals(operation)) {
                wordDictionary.addWord(params[i][0]);
                results.add(null);
            } else if ("search".equals(operation)) {
                results.add(wordDictionary.search(params[i][0]));
            } else {
                throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }

        return results;
    }

    private static void compare(List<Boolean> actual, List<Boolean> expected) {
        if (actual.size() != expected.size()) {
            System.out.println("Size mismatch: actual=" + actual.size() + ", expected=" + expected.size());
        }

        int count = Math.min(actual.size(), expected.size());
        for (int i = 0; i < count; i++) {
            if (!same(actual.get(i), expected.get(i))) {
                System.out.println("Mismatch at index " + i
                        + ": actual=" + actual.get(i)
                        + ", expected=" + expected.get(i));
                return;
            }
        }

        if (actual.size() == expected.size()) {
            System.out.println("All results match.");
        }
    }

    private static boolean same(Boolean a, Boolean b) {
        return a == b || a != null && a.equals(b);
    }

    private static TestInput defaultInput() throws IOException {
        if (Files.exists(LARGE_TEST_INPUT)) {
            return readInput(LARGE_TEST_INPUT);
        }

        String[] operations = {
                "WordDictionary",
                "addWord",
                "addWord",
                "addWord",
                "search",
                "search",
                "addWord",
                "search",
                "addWord",
                "search"
        };
        String[][] params = {
                {},
                {"xgvk"},
                {"wykzbvwdsoyfowqicymzd"},
                {"xajbtjyjuwgoynjgu"},
                {"wykzbvwdso..owqicymzd"},
                {"..ha"},
                {"qsibzxaorktypkfg"},
                {"xgvk"},
                {"vbycuvrkbcq"},
                {"qsibz.aorkty.kfg"}
        };
        return new TestInput(operations, params, Arrays.asList(null, null, null, null, true, false, null, true, null, true));
    }

    private static TestInput readInput(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path).stream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .filter(line -> !line.startsWith("#"))
                .toList();

        if (lines.size() < 2) {
            throw new IllegalArgumentException("Input file must contain operations on line 1 and params on line 2.");
        }

        List<Boolean> expected = lines.size() >= 3 ? parseBooleanArray(lines.get(2)) : null;
        return new TestInput(parseStringArray(lines.get(0)), parseStringMatrix(lines.get(1)), expected);
    }

    private static String[] parseStringArray(String input) {
        List<String> values = new ArrayList<>();
        int i = skipWhitespace(input, 0);
        require(input, i++, '[');

        while (true) {
            i = skipWhitespace(input, i);
            if (input.charAt(i) == ']') {
                return values.toArray(String[]::new);
            }

            ParsedString parsed = parseString(input, i);
            values.add(parsed.value);
            i = skipWhitespace(input, parsed.nextIndex);

            if (input.charAt(i) == ',') {
                i++;
            } else if (input.charAt(i) != ']') {
                throw new IllegalArgumentException("Expected ',' or ']' at index " + i);
            }
        }
    }

    private static String[][] parseStringMatrix(String input) {
        List<String[]> rows = new ArrayList<>();
        int i = skipWhitespace(input, 0);
        require(input, i++, '[');

        while (true) {
            i = skipWhitespace(input, i);
            if (input.charAt(i) == ']') {
                return rows.toArray(String[][]::new);
            }

            ParsedRow row = parseRow(input, i);
            rows.add(row.values);
            i = skipWhitespace(input, row.nextIndex);

            if (input.charAt(i) == ',') {
                i++;
            } else if (input.charAt(i) != ']') {
                throw new IllegalArgumentException("Expected ',' or ']' at index " + i);
            }
        }
    }

    private static List<Boolean> parseBooleanArray(String input) {
        List<Boolean> values = new ArrayList<>();
        int i = skipWhitespace(input, 0);
        require(input, i++, '[');

        while (true) {
            i = skipWhitespace(input, i);
            if (input.charAt(i) == ']') {
                return values;
            }

            if (input.startsWith("null", i)) {
                values.add(null);
                i += 4;
            } else if (input.startsWith("true", i)) {
                values.add(true);
                i += 4;
            } else if (input.startsWith("false", i)) {
                values.add(false);
                i += 5;
            } else {
                throw new IllegalArgumentException("Expected null, true, or false at index " + i);
            }

            i = skipWhitespace(input, i);
            if (input.charAt(i) == ',') {
                i++;
            } else if (input.charAt(i) != ']') {
                throw new IllegalArgumentException("Expected ',' or ']' at index " + i);
            }
        }
    }

    private static ParsedRow parseRow(String input, int index) {
        List<String> values = new ArrayList<>();
        int i = skipWhitespace(input, index);
        require(input, i++, '[');

        while (true) {
            i = skipWhitespace(input, i);
            if (input.charAt(i) == ']') {
                return new ParsedRow(values.toArray(String[]::new), i + 1);
            }

            ParsedString parsed = parseString(input, i);
            values.add(parsed.value);
            i = skipWhitespace(input, parsed.nextIndex);

            if (input.charAt(i) == ',') {
                i++;
            } else if (input.charAt(i) != ']') {
                throw new IllegalArgumentException("Expected ',' or ']' at index " + i);
            }
        }
    }

    private static ParsedString parseString(String input, int index) {
        StringBuilder value = new StringBuilder();
        int i = skipWhitespace(input, index);
        require(input, i++, '"');

        while (i < input.length()) {
            char c = input.charAt(i++);
            if (c == '"') {
                return new ParsedString(value.toString(), i);
            }
            if (c == '\\') {
                if (i >= input.length()) {
                    throw new IllegalArgumentException("Unclosed escape sequence");
                }
                value.append(input.charAt(i++));
            } else {
                value.append(c);
            }
        }

        throw new IllegalArgumentException("Unclosed string starting at index " + index);
    }

    private static int skipWhitespace(String input, int index) {
        while (index < input.length() && Character.isWhitespace(input.charAt(index))) {
            index++;
        }
        return index;
    }

    private static void require(String input, int index, char expected) {
        if (index >= input.length() || input.charAt(index) != expected) {
            throw new IllegalArgumentException("Expected '" + expected + "' at index " + index);
        }
    }

    private record TestInput(String[] operations, String[][] params, List<Boolean> expected) {
    }

    private record ParsedString(String value, int nextIndex) {
    }

    private record ParsedRow(String[] values, int nextIndex) {
    }
}

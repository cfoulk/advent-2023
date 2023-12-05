package com.advent.day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Question2 {

    private static Map<String, Integer> dictionary = new HashMap<>() {
        {
            put("one",1);
            put("two",2);
            put("three",3);
            put("four",4);
            put("five",5);
            put("six",6);
            put("seven",7);
            put("eight",8);
            put("nine",9);
        }};

    public static void main(String[] args) {

        try {
            int sum = 0;
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/com/advent/day_1/Question2.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                Pair first = getFirst(line);
                Pair last = getLast(line);
                String curr = "";
                if (first.substring && dictionary.containsKey(first.value)) {
                    curr += Integer.toString(dictionary.get(first.value));
                } else {
                    curr += String.valueOf(line.charAt(first.index));
                }

                if (last.substring && dictionary.containsKey(last.value)) {
                    curr += Integer.toString(dictionary.get(last.value));
                } else {
                    curr += String.valueOf(line.charAt(last.index));
                }
                System.out.println(curr);
                sum += Integer.parseInt(curr);
            }
            br.close();
            System.out.println(sum);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static Pair getFirst(String input) {

        String substring = "";
        int stringIndex = Integer.MAX_VALUE;
        int digitIndex = Integer.MAX_VALUE;

        outerloop:
        for (int i = 0; i < input.length() - 3; i++) {
            for (int j = i + 1; j < input.length() && j <= i + 5; j++) {
                if (dictionary.containsKey(input.substring(i, j))) {
                    stringIndex = i;
                    substring = input.substring(i, j);
                    break outerloop;
                }
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digitIndex = i;
                break;
            }
        }

        return (digitIndex < stringIndex) ? new Pair(digitIndex, String.valueOf(input.charAt(digitIndex)), false)
                : new Pair(stringIndex, substring, true);
    }

    private static Pair getLast(String input) {

        String substring = "";
        int stringIndex = Integer.MIN_VALUE;
        int digitIndex = Integer.MIN_VALUE;

        outerloop:
        for (int i = input.length(); i >= 2; i--) {
            for (int j = i - 1; j >= 0 && j >= i - 5; j--) {
                if (dictionary.containsKey(input.substring(j, i))) {
                    stringIndex = j;
                    substring = input.substring(j, i);
                    break outerloop;
                }
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if (Character.isDigit(input.charAt(i))) {
                digitIndex = i;
                break;
            }
        }

        return (digitIndex > stringIndex) ? new Pair(digitIndex, String.valueOf(input.charAt(digitIndex)), false)
                : new Pair(stringIndex, substring, true);
    }
}

class Pair {
    int index;
    String value;
    boolean substring;

    public Pair(int index, String value, boolean substring) {
        this.index = index;
        this.value = value;
        this.substring = substring;
    }
}

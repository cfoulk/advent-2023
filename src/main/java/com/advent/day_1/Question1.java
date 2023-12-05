package com.advent.day_1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Question1 {
    public static void main(String[] args) {

        try {
            int sum = 0;
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/com/advent/day_1/Question1.txt"));
            String line;
            while((line = br.readLine()) != null) {
                // System.out.println(line);
                sum += getNums(line);
            }
            br.close();
            System.out.println(sum);
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    private static int getNums(String input) {
        
        int left = 0, right = input.length() - 1;
        String res ="";

        boolean first = false, last = false;
        while(!first || !last) {
            if(!first) {
                if(Character.isDigit(input.charAt(left))) first = true; 
                else left++;
            }
            if(!last) {
                if(Character.isDigit(input.charAt(right))) last = true; 
                else right--;
            }

        }

        res += Character.toString(input.charAt(left));
        res += Character.toString(input.charAt(right));
        System.out.println(res);
        return Integer.parseInt(res);
    }
}

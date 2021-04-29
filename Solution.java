package com.codegym.task.task18.task1816;

/* 
ABCs

*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            map.put(String.valueOf(ch), 0);
        }
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            map.put(String.valueOf(ch), 0);
        }

        File f = new File(args[0]);
        String fcontent = "";
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            fcontent = fcontent + s;
        }
        sc.close();

        int count = 0;
        String[] ar = fcontent.split("");

        for (int i = 0; i<ar.length; i++) {
            if (ar[i].matches("[a-zA-Z]")) {
                for (int j = 0; j < ar.length; j++) {
                    if (ar[i].equals(ar[j])) {
                        count++;
                    }
                }
                map.put(ar[i], count);
                count = 0;
            }
        }

        for (Map.Entry<String, Integer> en : map.entrySet()) {
            System.out.println(en.getKey() + ": " + en.getValue());
        }
    }
}

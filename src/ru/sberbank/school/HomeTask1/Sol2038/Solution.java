package ru.sberbank.school.HomeTask1.Sol2038;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                count++;
            } else {
                if (count > maxCount)
                    maxCount = count;
                count = 0;
            }
        }

        System.out.println(maxCount);
    }
}

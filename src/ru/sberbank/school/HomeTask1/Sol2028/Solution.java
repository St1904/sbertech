package ru.sberbank.school.HomeTask1.Sol2028;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = new int[5];
        for (int i = 0; i < n; i++) {
            result[sc.nextInt()]++;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0)
                System.out.println(i + " " + result[i]);
        }
    }
}

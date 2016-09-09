package ru.sberbank.school.Sol2006;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cm = sc.nextInt();
        int ft = cm / 36;
        int inch = (cm % 36 + 1) / 3;
        System.out.println(ft + " " + inch);
    }
}

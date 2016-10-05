package ru.sberbank.school.HomeTask7;

public class Main {
    public static void main(String[] args) {
        Calculator cached = CacheProxy.makeCached(new CacheCalc());
        System.out.println(cached.plusOne(1));
        System.out.println(cached.plusOne(2));
        System.out.println(cached.plusOne(1));
        System.out.println();

        System.out.println(cached.minusOne(1));
        System.out.println(cached.minusOne(2));
        System.out.println(cached.minusOne(1));
    }
}

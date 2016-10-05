package ru.sberbank.school.HomeTask7;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calc();
        System.out.println(calc.calc(1));

        Calculator cached = CacheProxy.makeCached(calc);
        System.out.println(cached.calc(1));
        System.out.println(cached.calc(2));
        System.out.println(cached.calc(1));
    }
}

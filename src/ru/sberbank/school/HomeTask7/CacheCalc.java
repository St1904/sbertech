package ru.sberbank.school.HomeTask7;

public class CacheCalc implements Calculator {
    @Override
    @Cache
    public int calc(int x) {
        System.out.println("Это сделал CacheCalc");
        return x + 1;
    }
}

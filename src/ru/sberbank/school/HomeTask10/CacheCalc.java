package ru.sberbank.school.HomeTask10;

public class CacheCalc implements Calculator {
    @Override
    public int plusOne(int x) {
        return x + 1;
    }

    @Override
    public int minusOne(int x) {
        return x - 1;
    }
}

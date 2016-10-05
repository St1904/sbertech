package ru.sberbank.school.HomeTask7;

public class Calc implements Calculator {
    @Override
    public int calc (int x) {
        System.out.println("Это сделал Calc");
        return x + 1;
    }
}

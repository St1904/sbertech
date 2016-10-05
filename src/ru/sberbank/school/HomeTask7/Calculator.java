package ru.sberbank.school.HomeTask7;

public interface Calculator {
    @Cache
    int plusOne(int x);
    int minusOne(int x);
}

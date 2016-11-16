package ru.sberbank.school.HomeTask10;

public interface Calculator {
    @Cache
    int plusOne(int x);
    int minusOne(int x);
}

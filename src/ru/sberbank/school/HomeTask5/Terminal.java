package ru.sberbank.school.HomeTask5;

public interface Terminal {
    void enterPin(int pin);
    int checkAccount();
    void putMoney(int money);
    void pullMoney(int money);
}

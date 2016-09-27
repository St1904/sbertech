package ru.sberbank.school.HomeTask5;

public class TerminalServer {
    private int account;

    public TerminalServer() {
        this.account = 0;
    }

    void putMoney(int money) {
        account += money;
    }

    void pullMoney(int money) {
        account -= money;
    }

    int checkMoney() {
        return account;
    }
}

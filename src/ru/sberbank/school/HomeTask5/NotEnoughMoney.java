package ru.sberbank.school.HomeTask5;

public class NotEnoughMoney extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public NotEnoughMoney() {

    }

    public NotEnoughMoney(String message) {
        super(message);
    }
}

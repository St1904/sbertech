package ru.sberbank.school.HomeTask5;

public class IncorrectAmount extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public IncorrectAmount(String message) {
        super(message);
    }
}

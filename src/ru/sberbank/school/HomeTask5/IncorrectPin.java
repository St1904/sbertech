package ru.sberbank.school.HomeTask5;

public class IncorrectPin extends RuntimeException  {
    static final long serialVersionUID = -7034897190745766939L;

    public IncorrectPin() {
    }

    public IncorrectPin(String message) {
        super(message);
    }
}

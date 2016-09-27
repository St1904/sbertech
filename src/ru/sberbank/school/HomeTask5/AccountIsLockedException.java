package ru.sberbank.school.HomeTask5;

public class AccountIsLockedException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public AccountIsLockedException() {
        super();
    }

    public AccountIsLockedException(String message) {
        super(message);
    }
}

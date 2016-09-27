package ru.sberbank.school.HomeTask5;

import java.util.Date;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private final View view;

    private boolean pinCorrect;
    private int pinCount;
    private Date startLocking;

    TerminalImpl() {
        server = new TerminalServer();
        pinValidator = new PinValidator();
        view = new View();
        pinCount = 0;
    }

    @Override
    public void enterPin(int pin) throws IncorrectPin, AccountIsLockedException {
        if (startLocking != null && new Date().getTime() > startLocking.getTime() + 5000) {
            startLocking = null;
            pinCount = 0;
        }

        if (pinValidator.check(pin) && startLocking == null) {
            pinCorrect = true;
        } else {
            pinCount++;
            if (pinCount < 3) {
                throw new IncorrectPin("Неверный пин!");
            } else {
                if (startLocking == null) {
                    startLocking = new Date();
                }
                throw new AccountIsLockedException("Счет будет разблокирован " + new Date(startLocking.getTime() + 5000).toString());
            }
        }
    }

    @Override
    public int checkAccount() {
        if (pinCorrect)
            return server.checkMoney();
        else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }

    @Override
    public void putMoney(int money) throws IncorrectAmount {
        if (pinCorrect) {
            if (money % 100 == 0)
                server.putMoney(money);
            else
                throw new IncorrectAmount("Сумма должна быть кратна 100.");
        } else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }

    @Override
    public void pullMoney(int money) throws IncorrectAmount {
        if (pinCorrect) {
            if (money % 100 == 0)
                server.pullMoney(money);
            else
                throw new IncorrectAmount("Сумма должна быть кратна 100.");
        } else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }
}

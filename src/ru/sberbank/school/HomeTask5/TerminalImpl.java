package ru.sberbank.school.HomeTask5;

import java.util.Date;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    private final View view;

    private boolean pinCorrect;
    private int pinCount;
    private Date endLocking;

    TerminalImpl() {
        server = new TerminalServer();
        pinValidator = new PinValidator();
        view = new View();
        pinCount = 0;
    }

    @Override
    public void enterPin(int pin) throws IncorrectPin, AccountIsLockedException {
        if (endLocking != null && new Date().getTime() > endLocking.getTime()) {
            endLocking = null;
            pinCount = 0;
        }

        if (pinValidator.check(pin) && endLocking == null) {
            pinCorrect = true;
        } else {
            pinCount++;
            if (pinCount < 3) {
                throw new IncorrectPin("Неверный пин!");
            } else {
                if (endLocking == null) {
                    endLocking = new Date(new Date().getTime() + 5000);
                }
                int timeLeft = (int) (endLocking.getTime() - new Date().getTime()) / 1000;
                throw new AccountIsLockedException("Счет будет разблокирован через " + timeLeft + " секунд.");
            }
        }
    }

    @Override
    public int checkAccount() throws IncorrectPin {
        if (pinCorrect)
            return server.checkMoney();
        else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }

    @Override
    public void putMoney(int money) throws IncorrectAmount, IncorrectPin {
        if (pinCorrect) {
            if (money % 100 == 0)
                server.putMoney(money);
            else
                throw new IncorrectAmount("Сумма должна быть кратна 100.");
        } else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }

    @Override
    public void pullMoney(int money) throws IncorrectAmount, IncorrectPin, NotEnoughMoney {
        if (pinCorrect) {
            if (money % 100 == 0) {
                if (server.checkMoney() < money)
                    throw new NotEnoughMoney("Недостаточно денег на счете.");
                server.pullMoney(money);
            } else
                throw new IncorrectAmount("Сумма должна быть кратна 100.");
        } else throw new IncorrectPin("Для доступа к счету сначала введите пин.");
    }
}

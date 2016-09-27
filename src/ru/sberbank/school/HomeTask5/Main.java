package ru.sberbank.school.HomeTask5;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Terminal terminal = new TerminalImpl();

        try {
            terminal.enterPin(1);
        } catch (IncorrectPin e) {}
        try {
            terminal.enterPin(1);
        } catch (IncorrectPin e) {}

        try {
            terminal.enterPin(1);
        } catch (AccountIsLockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            terminal.enterPin(1);
        } catch (AccountIsLockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            terminal.enterPin(1);
        } catch (AccountIsLockedException e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(5000);

        try {
            terminal.enterPin(1);
        } catch (IncorrectPin e) {
            System.out.println(e.getMessage());
        }


//        try {
//            terminal.enterPin(123);
//        } catch (IncorrectPin e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            terminal.putMoney(120);
//        } catch (IncorrectPin e) {
//            System.out.println(e.getMessage());
//        }
//
//        terminal.enterPin(1234);
//
//        System.out.println(terminal.checkAccount());
//        terminal.putMoney(100);
//        System.out.println(terminal.checkAccount());
//
//        try {
//            terminal.putMoney(120);
//        } catch (IncorrectAmount e) {
//            System.out.println(e.getMessage());
//        }
//
    }
}

package ru.sberbank.school.HomeTask5;

import java.util.Scanner;

public class View {
    static Terminal terminal = new TerminalImpl();

    public void show(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        String s = "";
        Scanner sc = new Scanner(System.in);
        while (!s.equals("end")) {
            System.out.print("Введите команду. Для справки введите \"help\" ->   ");
            s = sc.nextLine();
            String ss[] = s.split(" ");
            switch (ss[0]) {
                case "help" :
                    System.out.println("    Введите end для выхода");
                    System.out.println("    Введите pin XXXX, чтобы ввести пин");
                    System.out.println("    Введите check, чтобы проверить состояние счета");
                    System.out.println("    Введите put XXX чтобы положить XXX денег на счет");
                    System.out.println("    Введите pull XXX чтобы снять XXX денег на счет");
                    break;
                case "pin" :
                    try {
                        terminal.enterPin(Integer.parseInt(ss[1]));
                        System.out.println("Корректный пин.");
                    } catch (IncorrectPin | AccountIsLockedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "check" :
                    try {
                        System.out.println(terminal.checkAccount());
                    } catch (IncorrectPin e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "put" :
                    try {
                        terminal.putMoney(Integer.parseInt(ss[1]));
                        System.out.println("Успешно.");
                    } catch (IncorrectPin | IncorrectAmount e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pull" :
                    try {
                        terminal.pullMoney(Integer.parseInt(ss[1]));
                        System.out.println("Успешно.");
                    } catch (IncorrectAmount | IncorrectPin | NotEnoughMoney e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "end" :
                    System.out.println("Спасибо, что воспользовались нашим терминалом =)");
                    break;
            }
        }
    }
}

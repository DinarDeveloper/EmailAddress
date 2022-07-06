import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> emailList = new TreeSet<>();

        System.out.println("Введите команду. Пример:");
        System.out.println("\tADD hello@skillbox.ru - добавить адрес электронной почты" +
                " \n\tLIST - вывести список электронных адресов" +
                "\n\tCLEAR - очистить список" +
                "\n\tEXIT - закрыть приложение");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] command = scanner.nextLine().split(" +", 2);

            switch (command[0]) {
                case "ADD":
                    if (command.length == 2 && command[1].contains("@")) {
                        emailList.add(command[1]);
                        System.out.println("Электронная почта сохранена");
                    } else {
                        System.out.println("Неверный формат ввода");
                    }
                    break;
                case "LIST":
                    if (emailList.size() == 0) {
                        System.out.println("Список пуст");
                    } else {
                        AtomicInteger count = new AtomicInteger(1);
                        emailList.forEach(email -> System.out.println(count.getAndIncrement() + " - " + email));
                    }
                    break;
                case "CLEAR":
                    emailList.clear();
                    System.out.println("Список очищен");
                    break;
                case "EXIT":
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}
// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Вы ввели число: " + number);
    }

    private static float readFloatFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Введите дробное число: ");
                    String input = scanner.nextLine();
                    float number = Float.parseFloat(input);
                    return number;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное число.");
                }
            }
        }
    }
}

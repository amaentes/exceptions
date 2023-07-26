// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();
            try {
                if (input.isEmpty()) {
                    throw new Exception("Пустые строки вводить нельзя!");
                }
                System.out.println("Вы ввели: " + input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}



import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class UserData {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private String phoneNumber;
    private char gender;

    public UserData(String surname, String name, String patronymic, String birthDate, String phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}

class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

class DataFormatException extends Exception {
    public DataFormatException(String message) {
        super(message);
    }
}

public class Main5 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите данные: ");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new InvalidDataException("Неверное количество данных");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];

            if (!isValidBirthDate(birthDate)) {
                throw new DataFormatException("Неверный формат даты рождения");
            }

            if (!isValidPhoneNumber(phoneNumber)) {
                throw new DataFormatException("Неверный формат номера телефона");
            }

            char gender = data[5].charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new DataFormatException("Неверный формат пола");
            }

            UserData userData = new UserData(surname, name, patronymic, birthDate, phoneNumber, gender);
            saveUserDataToFile(userData);
        } catch (InvalidDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (DataFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidBirthDate(String birthDate) {
        // Проверка формата даты рождения
        // В данном примере просто проверяем, что строка имеет длину 10 символов
        return birthDate.length() == 10;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Проверка формата номера телефона
        // В данном примере просто проверяем, что строка состоит только из цифр
        return phoneNumber.matches("\\d+");
    }

    private static void saveUserDataToFile(UserData userData) throws IOException {
        String fileName = "users.txt";
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(userData.getFullName() + ", " + userData.getBirthDate() + ", " +
                userData.getPhoneNumber() + ", " + userData.getGender() + "\n");
        writer.close();
    }
}

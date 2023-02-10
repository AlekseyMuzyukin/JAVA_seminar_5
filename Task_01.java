import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task_01 {

    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, String> phoneBook = FillPhoneBook();
        System.out.println(phoneBook);
        PrintPhonebook(phoneBook);
    }

    public static Map<String, String> FillPhoneBook() {
        Map<String, String> newPhoneBook = new HashMap<>();
        while (true) {
            String nextLine;
            String[] next = new String[2];
            System.out.print("Введите фамилию и телефон через пробел (распечатать - print): ");
            nextLine = iScanner.nextLine();
            if (Objects.equals(nextLine, "print"))
                break;
            else {
                next[0] = nextLine.split(" ")[0];
                next[1] = nextLine.split(" ")[1];
                newPhoneBook.put(next[1], next[0]);
            }
        }
        return newPhoneBook;
    }

    public static void PrintPhonebook(Map<String, String> phoneBook) {
        System.out.println("фамилия | Телефон");
        for (var entry : phoneBook.entrySet()) {
            System.out.print(entry.getValue() + " | ");
            System.out.println(entry.getKey());
        }
    }
}

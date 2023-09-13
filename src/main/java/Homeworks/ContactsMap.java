package Homeworks;
import java.util.*;
public class ContactsMap {
    static Map<String, LinkedList<String>> contactsMap = new HashMap<>();
    private static void addNumber(String[] str) {
        if (contactsMap.containsKey(str[1])) {
            LinkedList<String> currentNumbersList = new LinkedList<>();
            String currentName = str[1];
            currentNumbersList = contactsMap.get(currentName);
            currentNumbersList.add(str[2]);
            currentNumbersList.sort(Comparator.reverseOrder());
            contactsMap.put(currentName, currentNumbersList);
        }
        else{
            String currentName = str[1];
            LinkedList<String> currentNumbersList = new LinkedList<>();
            currentNumbersList.add(str[2]);
            currentNumbersList.sort(Comparator.reverseOrder());
            contactsMap.put(currentName, currentNumbersList);
        }
    }
    private static void getNumbers(String[] str) {
        if (contactsMap.containsKey(str[1])) {
            String currentName = str[1];
            LinkedList<String> currentNumbersList = contactsMap.get(currentName);
            System.out.printf("%s - %s \n", currentName, currentNumbersList);
        }
        else System.out.printf("Не найдена запись с фамилией %s \n", str[1]);
    }
    public static void main(String[] args) {
        System.out.println("Input command");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] string = input.split(" ");

        while (!string[0].equals("exit")) {
            if (string[0].equalsIgnoreCase("add")) {
                addNumber(string);
            } else if (string[0].equalsIgnoreCase("get")) {
                getNumbers(string);
            } else if (string[0].equalsIgnoreCase("remove")) {
                if (contactsMap.containsKey(string[1])) {
                    contactsMap.remove(string[1]);
                }
                else System.out.printf("Не найдена запись с фамилией %s \n", string[1]);
            } else if (string[0].equalsIgnoreCase("list")) {
                Set<String> contacts = contactsMap.keySet();
                for (String key : contacts) {
                    System.out.printf("%s -> %s%n", key, contactsMap.get(key));
                }
            }
            else break;
            System.out.println("Input command  ");
            input = scanner.nextLine();
            string = input.split(" ");
        }
    }
}
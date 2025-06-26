import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    private static Map<String, String> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Phone Book Menu ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting Phone Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        phoneBook.put(name, number);
        System.out.println("Contact added successfully.");
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        if (phoneBook.containsKey(name)) {
            System.out.println(name + "'s number is: " + phoneBook.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        if (phoneBook.remove(name) != null) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("\nAll Contacts:");
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                System.out.println("Name: " + entry.getKey() + " | Number: " + entry.getValue());
            }
        }
    }
}

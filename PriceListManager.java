import java.util.*;
import java.util.Scanner;
public class PriceListManager {
    private static Map<String, Double> priceList = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Price List Menu ===");
            System.out.println("1. Add Item");
            System.out.println("2. Display All Items");
            System.out.println("3. Sort Items (Low to High)");
            System.out.println("4. Sort Items (High to Low)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next(); // clear invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    sortItems(true); // low to high
                    break;
                case 4:
                    sortItems(false); // high to low
                    break;
                case 5:
                    System.out.println("Exiting Price List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price. Item not added.");
            return;
        }
        priceList.put(name, price);
        System.out.println("Item added successfully.");
    }
    private static void displayItems() {
        if (priceList.isEmpty()) {
            System.out.println("Price list is empty.");
        } else {
            System.out.println("\nAll Items:");
            for (Map.Entry<String, Double> entry : priceList.entrySet()) {
                System.out.println("Item: " + entry.getKey() + " | Price: $" + entry.getValue());
            }
        }
    }
    private static void sortItems(boolean ascending) {
        if (priceList.isEmpty()) {
            System.out.println("Price list is empty. Nothing to sort.");
            return;
        }
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(priceList.entrySet());
        sortedList.sort((a, b) -> {
            return ascending
                    ? Double.compare(a.getValue(), b.getValue())
                    : Double.compare(b.getValue(), a.getValue());
        });
        System.out.println("\nSorted Items (" + (ascending ? "Low to High" : "High to Low") + "):");
        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println("Item: " + entry.getKey() + " | Price: $" + entry.getValue());
        }
    }
}

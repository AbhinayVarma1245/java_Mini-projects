import java.util.*;

class Item {
    String name;
    double price;

    // Constructor
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // toString method for easy printing
    public String toString() {
        return name + ": $" + price;
    }
}

public class PriceList {
    public static void main(String[] args) {
        // Create a list of items
        List<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 1200));
        items.add(new Item("Headphones", 150));
        items.add(new Item("Keyboard", 75));
        items.add(new Item("Monitor", 300));
        items.add(new Item("Mouse", 50));
        items.add(new Item("Smartphone", 800));

        // Sort items from low to high price
        Collections.sort(items, Comparator.comparingDouble(item -> item.price));
        System.out.println("Price List: Low to High");
        System.out.println("------------------------");
        for (Item item : items) {
            System.out.println(item);
        }

        // Sort items from high to low price
        Collections.sort(items, (a, b) -> Double.compare(b.price, a.price));
        System.out.println("\nPrice List: High to Low");
        System.out.println("------------------------");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}

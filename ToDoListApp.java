import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== TO-DO LIST MENU ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private static void addTask() {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        System.out.println("1. Remove by Index");
        System.out.println("2. Remove by Task Name");
        System.out.print("Choose an option: ");
        int opt = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (opt == 1) {
            System.out.print("Enter index to remove (starting from 1): ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // consume newline
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid index.");
            }
        } else if (opt == 2) {
            System.out.print("Enter task name to remove: ");
            String name = scanner.nextLine();
            if (tasks.remove(name)) {
                System.out.println("Task removed.");
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
}

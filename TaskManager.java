import java.util.*;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class TaskManager {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return Integer.compare(t2.priority, t1.priority);
            }
        });

        taskQueue.add(new Task("Write report", 3));
        taskQueue.add(new Task("Fix bug", 5));
        taskQueue.add(new Task("Email client", 2));
        taskQueue.add(new Task("Plan meeting", 4));

        System.out.println("Tasks in priority order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}

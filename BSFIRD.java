import java.util.*;
import java.util.*;
public class BFSIRD {
    private Map<Integer, List<Integer>> adjList;
    public BSFIRD() {
        adjList = new HashMap<>();
    }
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BFSIRD graph = new BFSIRD();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.bfs(0);
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> storage = new PriorityQueue<>();
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            storage.add(scanner.nextInt());
        }
        System.out.println("Removing elements in sorted order:");
        while (!storage.isEmpty()) {
            System.out.print(storage.poll() + " ");
        }
        System.out.println();
    }
}

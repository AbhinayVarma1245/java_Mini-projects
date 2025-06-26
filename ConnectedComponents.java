import java.util.*;

public class ConnectedComponents {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public int countComponents() {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents graph = new ConnectedComponents();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        int components = graph.countComponents();
        System.out.println("Number of connected components: " + components);
    }
}

import java.util.*;

public class CycleDetectionUndirected {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, -1, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, node, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionUndirected graph = new CycleDetectionUndirected();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);

        if (graph.hasCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}

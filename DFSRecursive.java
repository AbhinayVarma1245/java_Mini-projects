import java.util.*;

public class DFSRecursive {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    // Add an edge to the graph (undirected by default)
    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // Remove this line for a directed graph
    }

    // Recursive DFS
    public void dfs(int node) {
        // Mark the current node as visited
        visited.add(node);
        System.out.print(node + " ");

        // Recur for all adjacent vertices not visited yet
        for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        DFSRecursive graph = new DFSRecursive();

        // Create a sample graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("DFS starting from node 0:");
        graph.dfs(0); // Starting DFS from node 0
    }
}

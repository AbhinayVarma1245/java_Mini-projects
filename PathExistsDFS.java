import java.util.*;

public class PathExistsDFS {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public boolean hasPath(int start, int end) {
        Set<Integer> visited = new HashSet<>();
        return dfs(start, end, visited);
    }

    private boolean dfs(int current, int target, Set<Integer> visited) {
        if (current == target) return true;
        visited.add(current);
        for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor) && dfs(neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathExistsDFS graph = new PathExistsDFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        int start = 0;
        int end = 4;

        if (graph.hasPath(start, end)) {
            System.out.println("Path exists between " + start + " and " + end);
        } else {
            System.out.println("No path exists between " + start + " and " + end);
        }
    }
}

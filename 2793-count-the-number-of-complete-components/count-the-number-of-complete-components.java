import java.util.*;

class Solution {
    private List<Integer>[] buildAdjList(int n, int[][] edges) {
        // Create an array of lists for an efficient adjacency list
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        return adjList;
    }

    private boolean bfs(List<Integer>[] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        visited[start] = true;
        
        int nodeCount = 0;
        int edgeCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodeCount++; // Count this node as part of the component
            
            for (int neighbour : graph[node]) {
                edgeCount++; // Count every directed edge instance
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        
        // In an undirected graph, each edge is traversed twice (u->v and v->u)
        int actualEdges = edgeCount / 2;
        
        // A complete component with 'm' nodes must have exactly m * (m - 1) / 2 edges
        return actualEdges == (nodeCount * (nodeCount - 1) / 2);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = buildAdjList(n, edges);
        boolean[] visited = new boolean[n];
        int completeComponentsCount = 0;
        
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                if (bfs(graph, node, visited)) {
                    completeComponentsCount++;
                }
            }
        }
        return completeComponentsCount;
    }
}
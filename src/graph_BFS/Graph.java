package graph_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int V; //number of vertices
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[startVertex] = true;
        q.add(startVertex);

        while (!q.isEmpty()) {
            int curVertex = q.poll();
            System.out.print(curVertex + " ");

            for (int neighbor : adjList.get(curVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}

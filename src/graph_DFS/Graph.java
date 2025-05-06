package graph_DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
    private int vertices;
    private List<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int des) {
        adjList[src].add(des);
        adjList[des].add(src);
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; //track visited nodes
        Stack<Integer> stack = new Stack<>(); // stack for traversal

        stack.push(startVertex); //start with the given vertex

        while (!stack.isEmpty()) {
            int curVertex = stack.pop();
            if (!visited[curVertex]) {
                System.out.println(curVertex + " ");//process current node
                visited[curVertex] = true;
            }

            for (int neighbor : adjList[curVertex]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }


    }
}

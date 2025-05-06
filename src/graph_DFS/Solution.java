package graph_DFS;

public class Solution {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        System.out.println("DFS Travesal starting from vertex 0:");
        g.DFS(0);
    }
}

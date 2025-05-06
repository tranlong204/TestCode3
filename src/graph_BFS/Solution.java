package graph_BFS;

public class Solution {
    public static void main(String[] args) {
        Graph graph = new Graph(5); //Create a graph with 6 vertices

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);

        System.out.println("Breadth first search starting from vertex 0:");
        graph.BFS(0);
    }
}

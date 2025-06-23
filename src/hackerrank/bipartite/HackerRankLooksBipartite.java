package hackerrank.bipartite;

import java.util.*;

public class HackerRankLooksBipartite {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = 0, M = 0;

        for (int t = 0; t < T; ++t) {
            N = sc.nextInt();
            M = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N; ++i) adj.add(new ArrayList<>());

            for (int i = 0; i < M; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u-1).add(v-1);
                adj.get(v-1).add(u-1);

            }
            System.out.println(isBipartite(adj)? "YES": "NO");
        }

    }

    public static boolean isBipartite(List<List<Integer>> adj) {
        int[] colors = new int[adj.size()];
        for (int i = 0; i < adj.size(); ++i) {
            if (colors[i] == 0 && !dfs(i, 1, adj,colors)) {
                return false;
            }
        }
        return true;

    }
    public static boolean dfs(int node, int color, List<List<Integer>> adj, int[] colors) {
        colors[node] = color;
        for (int nei: adj.get(node)) {
            if (colors[nei] == color) {
                return false;
            }
            if (colors[nei] == 0 && !dfs(nei, -color, adj, colors)) {
                return false;
            }
        }
        return true;
    }

}
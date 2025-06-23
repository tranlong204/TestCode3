package hackerrank.bipartite;

import java.util.*;

public class HackerRankLooksBipartite_openai {

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
            System.out.println(isBipartite(N, adj)? "YES": "NO");
        }

    }

    static boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // -1 = unvisited

        for (int start = 0; start < V; start++) {
            if (color[start] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[start] = 0;
                q.offer(start);

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


}
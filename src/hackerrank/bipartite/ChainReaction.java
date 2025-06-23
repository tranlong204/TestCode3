package hackerrank.bipartite;

import java.util.*;

public class ChainReaction {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = timeToInfect(grid);
        System.out.println(result);
    }

    public static int timeToInfect(int[][] grid) {
        int N = grid.length;
        int healthies = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    healthies++;
                }
            }
        }

        if (healthies == 0) return 0;

        //run bfs
        int time = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisRound = false;

            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];

                    if (isWithinBoundary(nr, nc, grid) && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        healthies--;
                        queue.offer(new int[]{nr, nc});
                        infectedThisRound = true;
                    }
                }
            }

            if (infectedThisRound) time++;
        }


        if (healthies == 0)
            return time;

        return -1;
    }

    public static boolean isWithinBoundary(int x, int y, int[][] grid) {
        return (0 <= x && x < grid.length && 0 <= y && y < grid[0].length);
    }

}
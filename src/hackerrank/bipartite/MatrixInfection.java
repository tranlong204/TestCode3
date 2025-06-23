package hackerrank.bipartite;

import java.util.*;

public class MatrixInfection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        // Read the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Run the infection simulation
        int result = timeToInfect(grid);
        System.out.println(result);
    }

    public static int timeToInfect(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int healthy = 0;

        // Add initially infected cells to queue and count healthy ones
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    healthy++;
                }
            }
        }

        if (healthy == 0) return 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        healthy--;
                        queue.offer(new int[]{nr, nc});
                        infectedThisRound = true;
                    }
                }
            }

            if (infectedThisRound) {
                time++;
            }
        }

        return healthy == 0 ? time : -1;
    }
}

package hackerrank.unionfind;

import java.util.*;

public class Solution {
/*
Sample input:
3 6
Q 1
M 1 2
Q 2
M 2 3
Q 3
Q 2

Sample output:
1
2
3
3

 */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        UnionFind uf = new UnionFind(N);

        while (Q-- >= 0) {
            String query = sc.nextLine();
            String[] content = query.split(" ");
            if ("M".equals(content[0])) {
                int x = Integer.parseInt(content[1]);
                int y = Integer.parseInt(content[2]);
                uf.union(x - 1, y - 1);
            } else if ("Q".equals(content[0])) {
                int t = Integer.parseInt(content[1]);
                System.out.println(uf.getSize(t - 1));
            }
        }


    }

    public static class UnionFind{
        private int[] parent;
        private int[] size;

        public UnionFind(int size) {
            this.parent = new int[size];
            this.size = new int[size];
            for (int i = 0; i < size; ++i) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int repX = this.find(x);
            int repY = this.find(y);

            if (repX != repY) {
                // If repX represents a larger community,
                // then connect repY's community to repX's
                if (this.size[repX] > this.size[repY]) {
                    this.parent[repY] = repX;
                    this.size[repX] += this.size[repY];
                } else {
                    this.parent[repX] = repY;
                    this.size[repY] += this.size[repX];
                }
            }
        }

        public int find(int x) {
            if (x == this.parent[x]) {
                return x;
            }
            // path compresion
            this.parent[x] = this.find(this.parent[x]);
            return this.parent[x];
        }

        public int getSize(int x) {
            return this.size[this.find(x)];
        }
    }
}

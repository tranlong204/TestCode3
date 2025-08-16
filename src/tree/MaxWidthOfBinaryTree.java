package tree;


import java.util.LinkedList;
import java.util.Queue;

class MaxWidthOfBinaryTree {

    public static void main(String[] args) {
        MaxWidthOfBinaryTree sol = new MaxWidthOfBinaryTree();

        // 1. Left-skewed tree
        TreeNode leftSkewed = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4), null), null), null);
        System.out.println("Left-skewed width: " + sol.widthOfBinaryTree(leftSkewed)); // Expected: 1

        // 2. Right-skewed tree
        TreeNode rightSkewed = new TreeNode(1,
                null, new TreeNode(2,
                null, new TreeNode(3,
                null, new TreeNode(4))));
        System.out.println("Right-skewed width: " + sol.widthOfBinaryTree(rightSkewed)); // Expected: 1

        // 3. Sparse tree (Leetcode example)
        TreeNode sparseTree = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5), new TreeNode(3)),
                new TreeNode(2,
                        null, new TreeNode(9)));
        System.out.println("Sparse tree width: " + sol.widthOfBinaryTree(sparseTree)); // Expected: 4

        // 4. Full tree (perfect binary tree of 3 levels)
        TreeNode fullTree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7)));
        System.out.println("Full tree width: " + sol.widthOfBinaryTree(fullTree)); // Expected: 4

        // 5. Tree with wide bottom level (sparse shape)
        TreeNode wideSparse = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8), null), null),
                new TreeNode(3,
                        null, new TreeNode(7,
                        null, new TreeNode(15))));
        System.out.println("Wide sparse tree width: " + sol.widthOfBinaryTree(wideSparse)); // Expected: 8
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLen = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftMost = 0;
            int rightMost = 0;
            int levelMinIndex = queue.peek().index;

            for (int i = 0; i < size; ++i) {
                Pair<TreeNode, Integer> nodePosition = queue.poll();
                int index = nodePosition.index - levelMinIndex; //normalize

                TreeNode node = nodePosition.node;
                if (i == 0)
                    leftMost = index;
                if (i == size -1)
                    rightMost = index;

                maxLen = Math.max(maxLen, rightMost - leftMost + 1);

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
        }

        return maxLen;

    }
    //time: O(N)
    //space: O(N)

    private static class Pair<T, K> {
        T node;
        K index;
        public Pair(T node, K index) {
            this.node = node;
            this.index = index;
        }
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
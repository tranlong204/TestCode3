package graph_BFS_tree;

import graph_BFS.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

    }
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //process the current node
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //preorder
    public void dfs_preorder(TreeNode root) {

        //process root;

        if (root.left != null) {
            dfs_preorder(root.left);
        }
        if (root.right != null) {
            dfs_preorder(root.right);
        }
    }

    //dfs_inorder
    public void dfs_inorder(TreeNode root) {


        if (root.left != null) {
            dfs_inorder(root.left);
        }

        //process root;

        if (root.right != null) {
            dfs_inorder(root.right);
        }
    }

    //dfs_postorder
    public void dfs_postorder(TreeNode root) {

        if (root.left != null) {
            dfs_postorder(root.left);
        }

        if (root.right != null) {
            dfs_postorder(root.right);
        }
        //process root;
    }


    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

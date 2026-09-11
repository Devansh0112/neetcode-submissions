/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // doing it without a queue - DFS

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> res) {
        if(node==null) return;

        if(depth == res.size()) {
            res.add(new ArrayList());
        }

        res.get(depth).add(node.val);

        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}

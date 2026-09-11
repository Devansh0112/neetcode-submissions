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

 // DFS iterative

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();

        stack.push(root);
        depths.push(0);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depths.pop();

            if(depth == result.size()) result.add(node.val);

            if(node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }

            if(node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }
        }
        return result;
    }
}

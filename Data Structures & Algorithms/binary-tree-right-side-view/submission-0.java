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

 // DFS version

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        List<List<Integer>> levels = new ArrayList<>();

        dfs(root, 0, levels);

        for(List<Integer> elem : levels) {
            result.add(elem.get(0));
        }
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> levels) {
        if (node == null) return;

        if(levels.size() == depth) levels.add(new ArrayList<>());

        levels.get(depth).add(node.val);

        dfs(node.right, depth+1, levels);
        dfs(node.left, depth+1, levels);
    }
}

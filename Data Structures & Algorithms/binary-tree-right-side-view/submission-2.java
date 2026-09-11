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

 // This is BFS version

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levels = new ArrayList<>();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                levels.add(node.val);

                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }

            result.add(levels.get(0));
        }

        return result;
    }
}

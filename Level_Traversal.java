import java.util.ArrayList;
import java.util.List;


public class Level_Traversal {
 
    public static class TreeNode {
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
    
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            traverse(result, root, 0);
            return result;
        }
        
        private void traverse(List<List<Integer>> list, TreeNode root, int idx) {
            if (root == null){
                return;
            }
            if (idx >= list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(idx).add(root.val);

            traverse(list, root.left, idx + 1);
            traverse(list, root.right, idx + 1);
        }
    }
}

public class ValidateBinarySearchTree {

    public class TreeNode {
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
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }

    boolean check(TreeNode root , TreeNode max , TreeNode min){
        if(root == null){
            return true;
        }

        if(min != null && root.val <= min.val){
            return false;
        } else if(max != null && root.val >= max.val){
            return false;
        }

        return (check(root.left,root,min) && check(root.right,max,root));
    }
}
}

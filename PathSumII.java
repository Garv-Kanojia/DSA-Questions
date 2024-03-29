import java.util.ArrayList;
import java.util.List;

/**
 * PathSumII
 */
public class PathSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            backtrack(result,new ArrayList<>() , root,targetSum);
            return result;
        }

        public void backtrack(List<List<Integer>> res , List<Integer> list ,TreeNode root ,int sum){
            if(root == null){
                return;
            }
            sum -= root.val;
            list.add(root.val);
            if(root.left == null && root.right == null){
                if(sum == 0){
                    res.add(new ArrayList<>(list));
                }
                list.remove(list.size()-1);
                return;
            }
            
            backtrack(res,list,root.left,sum);
            backtrack(res,list,root.right,sum);
            list.remove(list.size()-1);
        }
    }
}
import java.util.*;

public class RightSideView {

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

    static class Solution {
        static class Info{
            int vd;
            TreeNode node;

            Info(int dis , TreeNode n1){
                vd = dis;
                node = n1;
            }
        }
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            int max=0;
            Queue<Info> q = new LinkedList<>();
            q.add(new Info(0,root));
            q.add(null);
            Map<Integer,TreeNode> map = new HashMap<>();
            

            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                }

                else{
                    map.put(curr.vd,curr.node);
                    if(curr.node.left != null){
                        q.add(new Info(curr.vd + 1,curr.node.left));
                    }
                    if(curr.node.right != null){
                        q.add(new Info(curr.vd + 1,curr.node.right));
                    }
                    max = Math.max(max,curr.vd);
                }
            }

            for(int i=0 ; i<=max ;i++){
                res.add(map.get(i).val);
            }

            return res;
        }
    }
}

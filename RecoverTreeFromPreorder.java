public class RecoverTreeFromPreorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int i = 0;

        public TreeNode recoverFromPreorder(String tra) {
            return build(tra, 0);
        }

        public TreeNode build(String tra, int lvl) {
            if (i == tra.length()) {
                return null;
            }
            int j = i, c = 0;
            while (tra.charAt(j) == '-') {
                c += 1;
                j += 1;
            }
            if (c == lvl) {
                int k = j;
                while (j < tra.length() && tra.charAt(j) != '-') {
                    j += 1;
                }
                String sub = tra.substring(k, j);
                i = j;

                TreeNode root = new TreeNode(Integer.valueOf(sub));

                root.left = build(tra, lvl + 1);
                root.right = build(tra, lvl + 1);

                return root;
            } else {
                return null;
            }
        }
    }
}

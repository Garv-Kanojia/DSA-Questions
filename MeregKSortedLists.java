public class MeregKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0){
                return null;
            } else if(lists.length == 1){
                return lists[0];
            }

            return choose(lists,0,lists.length-1);
        }

        public ListNode choose(ListNode lists[] , int start , int end){
            if(start == end){
                return lists[start];
            } else if(start + 1 == end){
                return merge(lists[start],lists[end]);
            }

            int mid = start + (end - start)/2;
            ListNode left = choose(lists,start,mid);
            ListNode right = choose(lists,mid+1,end);

            return merge(left,right);
        }

        public ListNode merge(ListNode l1 , ListNode l2){
            ListNode dummy = new ListNode();
            ListNode dummy2 = dummy;

            while(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    dummy2.next = l2;
                    l2 = l2.next;
                } else{
                    dummy2.next = l1;
                    l1 = l1.next;
                }
                dummy2 = dummy2.next;
            }

            dummy2.next = (l1 == null) ? l2 : l1;

            return dummy.next;
        }
    }
}

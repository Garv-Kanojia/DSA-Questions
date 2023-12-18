public class swap_pairs { 
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 

    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            ListNode next2 = curr.next;
            curr.next = next2.next;
            pre.next = next2;
            next2.next = curr;
            pre = curr;
            curr = pre.next;
        }


        return dummy.next;
    }

}

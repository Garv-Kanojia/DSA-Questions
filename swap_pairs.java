public class swap_pairs { 
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;

        while(pre.next != null && pre.next.next != null){
            ListNode curr = pre.next;
            ListNode next2 = curr.next;
            pre = reverse(pre , curr , next2);
        }

        return dummyhead.next;
    }

    private static ListNode reverse(ListNode pre , ListNode curr , ListNode next2){
        pre.next = next2;
        curr.next = next2.next;
        next2.next = curr;
        return curr;
    }

}


public class Nth_delelte_from_end {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = head;

        while(n > 0){
            fast = fast.next;
            --n;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = temp.next;
        temp = null;

        return dummy.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

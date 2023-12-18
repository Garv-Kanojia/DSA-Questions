
public class Reverse_linkedlist_II {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode next2 = curr.next;

        for (int i = 0; i < right - left; i++) {
            curr.next = next2.next;
            next2.next = pre.next;
            pre.next = next2;
            next2 = curr.next;
        }
        return dummy.next;
    }

}
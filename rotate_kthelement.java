public class rotate_kthelement {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;
            ListNode reversed = reverse(groupPrev.next, groupNext);
            groupPrev.next = reversed;
            getKth(groupPrev, k).next = groupNext;
            groupPrev = getKth(groupPrev, k);
        }
        return dummy.next;
    }

    private static ListNode getKth(ListNode start, int k) {
        ListNode ptr = start;
        for (int i = 0; i < k; i++) {
            if (ptr == null) return null;
            ptr = ptr.next;
        }
        return ptr;
    }

    private static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        ListNode curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

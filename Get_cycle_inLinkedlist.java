public class Get_cycle_inLinkedlist {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag=0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            slow = null;
        }
        else{
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

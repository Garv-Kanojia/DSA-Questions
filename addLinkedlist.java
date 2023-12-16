
public class addLinkedlist {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(0);
        ListNode tail = dumy;
        int carry =0;

        while(l1 != null || l2 != null || carry != 0){
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            int num = sum%10;
            carry = sum/10;

            ListNode new_node = new ListNode(num);
            tail.next = new_node;
            tail = new_node;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dumy.next;
        dumy.next = null;
        return result;

    }
}

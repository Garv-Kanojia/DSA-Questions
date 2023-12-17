public class remove_duplicates_linkedlist {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while(temp != null){
            if(temp.next != null && temp.next.next != null && temp.next.val == temp.next.next.val){
                link(temp);
            }
            else{
                temp = temp.next;
            }
        }

        return dummy.next;
    }

    private static void link(ListNode node){
        ListNode node2 = node;
        do{
            node2 = node2.next;
        }
        while(node2.next != null && node2.val == node2.next.val);
        node.next = node2.next;
    }
}

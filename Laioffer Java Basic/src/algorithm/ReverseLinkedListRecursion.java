package algorithm;

// LaiCode 653
public class ReverseLinkedListRecursion {
    public class ListNode {
        ListNode next;
        int value;
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

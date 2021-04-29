package algorithm;

import java.util.List;

public class RemoveLinkedListElements {
    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode removeElement(ListNode head, int val) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            if (head.value != val) {
                pre = pre.next;
                head = head.next;
            } else { // head.value == val
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(8);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        int val = 5;
        System.out.println(test.removeElement(a, val));
    }
}

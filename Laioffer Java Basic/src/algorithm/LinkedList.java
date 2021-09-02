public class LinkedList {
    class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        // head == null
        return length;
    }

    public ListNode get(ListNode head, int index) {
        ListNode cur = head;
        while (cur != null && index > 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }


    public ListNode appendHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value);
//        if (head == null) {
//            return newHead;
//        }
        newHead.next = head;
        return newHead;
    }

    public ListNode appendTail(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }

//        ListNode pre = null;
        ListNode res = head;
        while (head.next!= null) {
            head = head.next;
        }
        head.next = new ListNode(value);;
        return res;
    }
}

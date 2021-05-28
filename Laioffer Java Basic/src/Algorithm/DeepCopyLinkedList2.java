package algorithm2;

public class DeepCopyLinkedList2 {
    public class Node {
        Node next;
        Node random;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Creating a new list of original and new A->A'->B->B'->C->C'
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.value);
            // insert the cloned node to the next of original
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;

        // Step 2: link the random of the new node
        while(cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }

        // Step 3: separate original and new linked list
        Node cur_old_list = head;
        Node cur_new_list = head.next;
        Node head_new = head.next; // used for return new head.
        while(cur_old_list != null) {
            cur_old_list.next = cur_old_list.next.next;
            cur_new_list.next = (cur_new_list.next != null) ? cur_new_list.next.next : null;
            cur_old_list = cur_old_list.next;
            cur_new_list = cur_new_list.next;
        }
        return head_new;
    }
}

package algorithm;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {
    public class RandomListNode {
        RandomListNode next;
        RandomListNode random;
        int value;
        public RandomListNode(int value) {
            this.value = value;
        }
    }
    public RandomListNode copy(RandomListNode head) {
        // corner case
        if (head == null) return null;

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            // pre is at the dummy now. the current node is at the pre.next.
            pre.next = map.get(head);
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                pre.next.random = map.get(head.random);
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
}

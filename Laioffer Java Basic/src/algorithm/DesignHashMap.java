import java.util.Arrays;

// Leetcode 706
// Solution 1 - array
//public class DesignHashMap {
//    int[] map;
//
//    public DesignHashMap() {
//        map = new int[1000001];
//        Arrays.fill(map, -1);
//    }
//
//    public void put(int key, int value) {
//        if(key >= 0 && key <= 1000000) {
//            map[key] = value;
//        }
//    }
//
//    public int get(int key) {
//        if(key < 0 || key > 1000000) {
//            return -1;
//        } else {
//            return map[key];
//        }
//    }
//
//    public void remove(int key) {
//        if(key >= 0 && key <= 1000000) {
//            map[key] = -1;
//        }
//    }
//}

// Solution 2: array + linkedlist
//public class DesignHashMap {
//    final ListNode[] nodes;
//    class ListNode {
//        int key;
//        int val;
//        ListNode next;
//
//        public ListNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    public DesignHashMap() {
//        nodes = new ListNode[1000000];
//    }
//
//    public void put(int key, int value) {
//        int i = hash(key);
//        if (nodes[i] == null) {
//            nodes[i] = new ListNode(-1, -1);
//        }
//        ListNode prev = find(nodes[i], key);
//        if (prev.next == null) {
//            prev.next = new ListNode(key, value);
//        } else {
//            prev.next.val = value;
//        }
//    }
//
//    public int get(int key) {
//        int i = hash(key);
//        if (nodes[i] == null) {
//            return -1;
//        }
//        ListNode node = find(nodes[i], key);
//        return node.next == null ? -1 : node.next.val;
//    }
//
//    public void remove(int key) {
//        int i = hash(key);
//        if (nodes[i] == null) {
//            return;
//        }
//        ListNode prev = find (nodes[i], key);
//        if (prev.next == null) {
//            return;
//        }
//        prev.next = prev.next.next;
//    }
//
//    public int hash(int key) {
//        return Integer.hashCode(key) % nodes.length;
//    }
//
//    public ListNode find(ListNode bucket, int key) {
//        ListNode node = bucket;
//        ListNode prev = null;
//        while (node != null || node.key != key) {
//            prev = node;
//            node = node.next;
//        }
//        return prev;
//    }
//}
//

public class DesignHashMap {
    class ListNode {
        ListNode next;
        int key;
        int val;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode[] map = new ListNode[1000001];
    int capacity;

    public DesignHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return -1;
        }
        ListNode pre = findNode(map[index], key);
        return pre.next == null ? -1 : pre.next.val;
    }

    public void put(int key, int val) {
        int index = hash(key);
        if (map[index] == null) {
            ListNode newNode = new ListNode(-1, -1);
        }
        ListNode pre = findNode(map[index], key);
        if (pre.next == null) {
            pre.next = new ListNode(key, val);
        }
        pre.next.val = val;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return;
        }
        ListNode pre = findNode(map[index], key);
        if (pre.next == null) {
            return;
        }
        pre.next = pre.next.next;
    }

    private int hash(int key) {
        return Integer.hashCode(key) % map.length;
    }

    private ListNode findNode(ListNode node, int key) {
        ListNode pre = null;
        while (node != null && node.key != key) {
            pre = node;
            node = node.next;
        }
        return pre;
    }
}

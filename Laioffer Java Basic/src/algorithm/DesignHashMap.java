// Leetcode 706
public class DesignHashMap {
    int[] map;

    public DesignHashMap() {
        map = new int[1000001];
    }

    public void put(int key, int value) {
        if(key >= 0 && key <= 1000000) {
            map[key] = value;
        }
    }

    public int get(int key) {
        if(key < 0 || key > 1000000) {
            return -1;
        } else {
            return map[key];
        }
    }

    public void remove(int key) {
        if(key >= 0 && key <= 1000000) {
            map[key] = -1;
        }
    }
}

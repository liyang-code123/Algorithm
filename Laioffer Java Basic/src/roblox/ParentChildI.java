package roblox;

import java.util.*;

public class ParentChildI {
    public List<List<Integer>> parentChildI(int[][] parentChild) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if (parentChild == null) {
            return res;
        }

        for (int[] pair : parentChild) {
            map.putIfAbsent(pair[1], new HashSet<>());
            map.putIfAbsent(pair[0], new HashSet<>());
            map.get(pair[1]).add(pair[0]);
        }

        List<Integer> noParent = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() == 0) {
                noParent.add(entry.getKey());
            }
            if(entry.getValue().size() == 1) {
                oneParent.add(entry.getKey());
            }
        }
        res.add(noParent);
        res.add(oneParent);
        return res;
    }

    public static void main(String[] args) {
        ParentChildI test = new ParentChildI();
        int[][] input = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}};
        for (int i = 0; i < test.parentChildI(input).size(); i++) {
            System.out.println(test.parentChildI(input).get(i).toString());
        }
    }
}

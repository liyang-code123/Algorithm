package algorithm;

import java.util.*;

public class AlienDictionary {
    public String alienDictionary(String[] words) {
        // step 0: find all unique letters, hashmap
        Map<Character, List<Character>> adjacentList = new HashMap<>();
        Map<Character, Integer> inDegreeCount = new HashMap<>();
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                inDegreeCount.put(c, 0);
                adjacentList.put(c, new ArrayList<>());
            }
        }

        // step 1: build adjacentList and inDegreeCount
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word2.startsWith(word1)) {
                return "";
            }

            for (int j = 0; i < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjacentList.get(word1.charAt(j)).add(word2.charAt(j)));
                    inDegreeCount.put(word2.charAt(j), inDegreeCount.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        for (Character c : inDegreeCount.keySet()) {
            if(inDegreeCount.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for (Character next : adjacentList.get(c)) {
                inDegreeCount.put(next, inDegreeCount.get(next) - 1);
                if (inDegreeCount.get(next).equals(0)) {
                    queue.offer(next);
                }
            }
        }

        if (sb.length() < inDegreeCount.size()) {
            return "";
        }
        return sb.toString();
    }
}

package ov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// HighSpot
public class MostFrequentCharacter {
    public Character mostFrequent(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        Map<Character, Integer> map = new HashMap<>();
        int globalMax = 0;
        Character res = null;
        for (int i = 0; i < input.length(); i++) {
            map.putIfAbsent(input.charAt(i), 1);
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
            globalMax = Math.max(globalMax, map.get(input.charAt(i)));
        }

        Set<Character> resSet = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == globalMax){
                resSet.add(entry.getKey());
            }
        }

        for (int i = input.length() - 1; i >= 0; i--) {
            if (resSet.contains(input.charAt(i))) {
                return input.charAt(i);
            }
        }
        return null;

    }
    public static void main(String[] args) {
        MostFrequentCharacter test = new MostFrequentCharacter();
        String input = "bbaar";
        String input1 = "foo";
        String input2 = "bar";
        String input3 = "ooo";
        String input4 = "";
        String input5 = "ababa";
        System.out.println(test.mostFrequent(input));
        System.out.println(test.mostFrequent(input1));
        System.out.println(test.mostFrequent(input2));
        System.out.println(test.mostFrequent(input3));
        System.out.println(test.mostFrequent(input4));
        System.out.println(test.mostFrequent(input5));
    }
}

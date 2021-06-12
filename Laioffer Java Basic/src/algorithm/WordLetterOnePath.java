package algorithm2;

import java.util.*;

public class WordLetterOnePath {
    public static List<String> wordLetterOnePath(String startWord, String endWord, List<String> dictionary) {
        Set<String> dict = new HashSet<>(dictionary);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        // key: pre, value: current word
        Map<String, String> pre = new HashMap<>();
        List<String> path = new ArrayList<>();

        // build the graph from the starWord.
        queue.offer(startWord);

//        breakOut:
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
//                    break breakOut;
                    break;
                }
                for (int i = 0; i < cur.length(); i++) {
                    char[] charArrayOfCur = cur.toCharArray();
                    for (char c = 'a'; c <='z'; c++) {
                        charArrayOfCur[i] = c;
                        String candidate = new String(charArrayOfCur);
                        if (!visited.contains(candidate) && dict.contains(candidate)) {
                            queue.offer(candidate);
                            visited.add(candidate);
                            pre.put(candidate, cur);
                        }
                    }
                }
            }
        }

        // add to the path from the end.
        String mid = endWord;
        path.add(endWord);
        while (!mid.equals(startWord)) {
            mid = pre.get(mid);
            path.add(mid);
        }

        Collections.reverse(path);

        return path;
    }

//    public static void main(String[] args) {
//        String startWord = "hit";
//        String endWord = "cog";
//        List<String> dictionary = new ArrayList<>();
//        dictionary.add("hot");
//        dictionary.add("lot");
//        dictionary.add("dot");
//        dictionary.add("log");
//        dictionary.add("dog");
//        dictionary.add("cog");
//        dictionary.add("zot");
//        dictionary.add("cot");
//
//        List<String> path = wordLetterOnePath(startWord, endWord, dictionary);
//        for (String p : path) {
//            System.out.println(p);
//        }
//    }
}
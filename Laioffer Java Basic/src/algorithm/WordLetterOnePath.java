package algorithm;

import java.util.*;

public class WordLetterOnePath {
    public static List<String> wordLetterOnePath(String startWord, String endWord, List<String> dictionary) {
        Set<String> dict = new HashSet<>(dictionary);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        // key: pre, value: current word
        Map<String, String> pre = new HashMap<>();
        List<String> path = new ArrayList<>();
        // queue offers from the starWord.
        queue.offer(startWord);

        breakOut:
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    break breakOut;
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

        String mid = endWord;
        path.add(endWord);
        while (!mid.equals(startWord)) {
            mid = pre.get(mid);
            path.add(mid);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("hot");
        dictionary.add("lot");
        dictionary.add("dot");
        dictionary.add("log");
        dictionary.add("dog");
        dictionary.add("cog");
        dictionary.add("zot");
        dictionary.add("cot");

        List<String> path = wordLetterOnePath(startWord, endWord, dictionary);
        for (String p : path) {
            System.out.println(p);
        }
    }
}


//public class WordLetterOnePath {
//    public static List<String> ladder(String sw, String ew, List<String> wordList) {
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        Queue<String> q = new ArrayDeque<>();
//        Map<String, String> pre = new HashMap<>();
//        List<String> path = new ArrayList<>();
//        int res = 1;
//        q.offer(sw);
//        breakOut:
//        while (!q.isEmpty()) {
//            int size = q.size();
//            //System.out.println(res);
//            while (size-- > 0) {
//                String curr = q.poll();
//                //System.out.println(curr);
//                if (curr.equals(ew)) {
//                    break breakOut;
//                }
//                for (int i = 0; i < curr.length(); i++) {
//                    char[] arrayOfCurr = curr.toCharArray();
//                    for (char c = 'z'; c >= 'a'; c--) {
//                        arrayOfCurr[i] = c;
//                        String candi = new String(arrayOfCurr);
//                        if (!visited.contains(candi) && dict.contains(candi)) {
//                            q.offer(candi);
//                            visited.add(candi);
//                            pre.put(candi, curr);
//                        }
//                    }
//                }
//            }
//            res++;
//        }
//        System.out.println(res);
//        String mid = ew;
//        path.add(ew);
//        while (!mid.equals(sw)) {
//            //System.out.println(mid);
//            mid = pre.get(mid);
//            path.add(mid);
//        }
//        Collections.reverse(path);
//
//        return path;
//    }
//    public static void main(String[] args) {
//        String sw = "hit";
//        String ew = "cot";
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("lot");
//        wordList.add("dot");
//        wordList.add("log");
//        wordList.add("dog");
//        wordList.add("cog");
//        wordList.add("zot");
//        wordList.add("cot");
//        List<String> path = ladder(sw, ew, wordList);
//        for (String p : path) {
//            System.out.println(p);
//        }
//    }
//}

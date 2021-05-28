package algorithm2;

import java.util.*;

public class WordLetterTwo {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int endIndex = wordList.indexOf(endWord);
        if (endIndex == -1) {
            return new ArrayList<>();
        }

        List<String> words;
        int beginIndex = wordList.indexOf(beginWord);
        if (beginIndex == -1) {
            words = new ArrayList<String>(wordList);
            words.add(beginWord);
            beginIndex = words.size() - 1;
        } else {
            words = wordList;
        }

        NeighborFinder finder = new NeighborFinder(words);
        Queue<Integer> queue = new ArrayDeque<>();
        int[] step = new int[words.size()];
        Arrays.fill(step, -1);

        queue.offer(beginIndex);
        step[beginIndex] = 0;
        Tracer tracer = new Tracer(words);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endIndex) {
                return tracer.findLadders(beginIndex, endIndex);
            }
            for (int y : finder.findNeighbors(x)) {
                if (step[y] == -1) {
                    queue.offer(y);
                    step[y] = step[x] + 1;
                }
                if (step[x] + 1 == step[y]) {
                    tracer.addPredecessor(x, y);
                }
            }
        }
        return new ArrayList<>();
    }

    static class NeighborFinder {
        private Map<String, Integer> wordIndex = new HashMap<>();
        private List<String> words;

        public NeighborFinder(List<String> words) {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                wordIndex.put(word, i);
            }
            this.words = words;
        }

        public List<Integer> findNeighbors(int i) {
            // why 16
            List<Integer> neighbors = new ArrayList<>(16);
            String word = words.get(i);
            StringBuilder wordModifier = new StringBuilder(word);
            for (int j = 0; j < wordModifier.length(); j++) {
                char orig = word.charAt(j);
                for (char c = 'a'; c <= 'z'; c++) {
                    if(c == orig) {
                        continue;
                    }
                    wordModifier.setCharAt(j, c);
                    int neighbor = wordIndex.getOrDefault(wordModifier.toString(), -1);
                    if (neighbor != -1) {
                        neighbors.add(neighbor);
                    }
                }
                wordModifier.setCharAt(j, orig);
            }
            return neighbors;
        }
    }

    static class Tracer {
        private List<String> words;
        private List<List<Integer>> preds;

        public Tracer (List<String> words) {
            this.words = words;

            preds = new ArrayList<>(words.size());
            for (int i = 0; i < words.size(); i++) {
                preds.add(new ArrayList<>(16));
            }
        }

        public void addPredecessor(int x, int y) {
            preds.get(y).add(x);
        }

        public List<List<String>> findLadders(int beginIndex, int y) {
            List<List<String>> ladders = new ArrayList<>();
            List<String> trace = new ArrayList<>();
            trace.add(words.get(y));
            findLaddersHelper(beginIndex, y, trace, ladders);
            return ladders;
        }

        private void findLaddersHelper(int beginIndex, int y, List<String> trace, List<List<String>> ladders) {
            if (beginIndex == y) {
                List<String> ladder = new ArrayList<>(trace);
                Collections.reverse(ladder);
                ladders.add(ladder);
                return;
            }
            for (int x : preds.get(y)) {
                trace.add(words.get(x));
                findLaddersHelper(beginIndex, x, trace, ladders);
                trace.remove(trace.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "git";
        String endWord = "hot";
        List<String> wordList = new ArrayList<>();
        wordList.add("git");
        wordList.add("hit");
        wordList.add("hog");
        wordList.add("hot");
        wordList.add("got");

        List<List<String>> path = findLadders(beginWord, endWord, wordList);
        for (List<String> p : path) {
            System.out.println(p);
        }
    }

}

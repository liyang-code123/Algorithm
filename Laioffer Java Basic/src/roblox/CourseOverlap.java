package roblox;

import java.util.*;

public class CourseOverlap {
    public Map<String[], List<String>> courseOverlap(String[][] coursePair) {
        Map<String[], List<String>> res = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();



        for(String[] str : coursePair) {
            map.putIfAbsent(str[0], new HashSet<>());
            map.get(str[0]).add(str[1]);
        }

        List<String> mainList = new ArrayList<>();
        mainList.addAll(map.keySet());

        for (int i = 0; i < mainList.size() - 1; ++i) {
            for (int j = i + 1; j < mainList.size(); ++j) {
                String[] studentPair = new String[2];
                studentPair[0] = mainList.get(i);
                studentPair[1] = mainList.get(j);
                res.put(studentPair, new ArrayList<>());
                for (String courseA: map.get(mainList.get(i))) {
                    if(map.get(mainList.get(j)).contains(courseA)) {
                        res.get(studentPair).add(courseA);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        CourseOverlap test = new CourseOverlap();
        String[][] coursePair = {{"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"}};
        Map<String[], List<String>> map = test.courseOverlap(coursePair);
        for(Map.Entry<String[], List<String>> e : map.entrySet()) {
            System.out.println(e.getKey()[0] + "," + e.getKey()[1]);
            for (String s : e.getValue()) {
                System.out.println(s);
            }
        }
    }
}

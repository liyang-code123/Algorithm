package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//LeetCode 811 // Roblox
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            int i = domain.indexOf(' ');
            int n = Integer.parseInt(domain.substring(0, i));
            String s = domain.substring(i + 1);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) =='.') {
                    String s1 = s.substring(j + 1);
                    map.put(s1, map.getOrDefault(s1, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }
        for (String s2 : map.keySet()) {
            res.add(map.get(s2) + " " + s2);
        }
        return res;
    }

    public static void main (String[] args) {
        SubdomainVisitCount test = new SubdomainVisitCount();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String ans:  test.subdomainVisits(cpdomains)) {
            System.out.println(ans);
        }
    }
}

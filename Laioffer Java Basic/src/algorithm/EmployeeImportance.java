package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 690
public class EmployeeImportance {
    static class Employee{
        int id;
        int importance;
        List<Integer> subordinates;
    }
    public int importance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee em : employees) {
            map.put(em.id, em);
        }
        int[] res = new int[1];
        dfs(map, id, res);
        return res[0];
    }

    private void dfs(Map<Integer, Employee> map, int id, int[] res) {
        res[0] += map.get(id).importance;
        for (Integer em : map.get(id).subordinates) {
            dfs(map, em, res);
        }
    }

    public static void main (String[] args) {
        EmployeeImportance test = new EmployeeImportance();
        Employee a = new Employee();
        Employee b = new Employee();
        Employee c = new Employee();
        Employee d = new Employee();
        a.id = 1;
        a.importance = 5;
        b.id = 2;
        b.importance = 3;
        c.id = 3;
        c.importance = 2;
        d.id = 4;
        d.importance = 1;
        a.subordinates.add(b.id);
        a.subordinates.add(c.id);
        b.subordinates.add(d.id);
        List<Employee> em = new ArrayList<>();
        em.add(a);
        em.add(b);
        em.add(c);
        em.add(d);
        System.out.println(test.importance(em, 1));
    }
}

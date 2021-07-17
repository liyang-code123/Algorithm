package ov;

import java.util.ArrayList;
import java.util.List;

// HealthCrowd OA
public class Fibonacci {
    public List<Integer> fibonacci(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        res.add(1);
        if (n == 1) {
            return res;
        }

        for (int i = 2; i < n; i++) {
            res.add(res.get(i - 1) + res.get(i -2));
        }
        return res;
    }

    public static void main(String[] args) {
        Fibonacci test = new Fibonacci();
        int n = 5;
        List<Integer> res = test.fibonacci(n);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

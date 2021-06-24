/*
C: input: four points.
output: if it is square.
the square may not be parallel to the x,y axis.
A:
R: step1: sort four points by x axis and then y axis.
step2: all the sides lengths are the same && diagonal lengths are the same.

What I learn from this problem:
a.  Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
b. geometry for square: all four sides are the same length && all diagonals are the same length.
c. actually only three comparison for all four sides required is enough.
d. Math.pow(a, 2), the second parameter is for the power.

TC: O(nlogn) --> O(1) as it has only 4 points.
SC: O(1)

*/

import java.util.Arrays;

// LeetCode 593
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return distance(p[0], p[1]) != 0
                && distance(p[0], p[1]) == distance(p[1], p[3])
                // && distance(p[1], p[3]) == distance(p[3], p[2]). we do not necessarily need this comparison.
                && distance(p[3], p[2]) == distance(p[2], p[0])
                && distance(p[0], p[3]) == distance(p[1], p[2]);
    }

    private double distance(int[] p1, int[] p2) {
        return Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2);
    }

    public static void main(String[] args) {
        ValidSquare test = new ValidSquare();
        int[] p1 = {0, 0};
        int[] p2 = {0, 1};
        int[] p3 = {1, 0};
        int[] p4 = {1, 1};
        System.out.println(test.validSquare(p1, p2, p3, p4));
    }
}

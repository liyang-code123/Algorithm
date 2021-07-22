package ov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RangeList {
    static class Range {
        int left;
        int right;
    }
    List<Range> rangeList = new ArrayList<>();

    private void add(Range range) {
        if (range == null || range.left >= range.right) {
            return;
        }
        int leftIndex = range.left;
        int rightIndex = range.right;


        Range leftInterval = binarySearch(rangeList, leftIndex);
        Range rightInterval = binarySearch(rangeList, rightIndex);

        merge(rangeList, leftInterval, rightInterval, leftIndex, rightIndex, range);
    }

    private Range binarySearch(List<Range> rangeList, int target) {
        int left = 0;
        int right = rangeList.size()- 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (rangeList.get(mid).left >= target) {
                right = mid;
            } else if (rangeList.get(mid).left < target) {
                left = mid;
            }
        }
        return rangeList.get(left);
    }

    private void merge(List<Range> rangeList, Range leftInterval, Range rightInterval, int leftIndex, int rightIndex, Range range) {
        int leftBoundStart = leftInterval.left;
        int leftBoundEnd = leftInterval.right;
        int rightBoundStart = rightInterval.left;
        int rightBoundEnd = rightInterval.right;
        if (leftIndex >= leftBoundStart && leftIndex < leftBoundEnd) {
//            if (rightIndex >= leftBoundStart && rightIndex < leftBoundEnd) {
//                continue;
//            } else
            if (rightIndex >= leftBoundEnd && rightIndex < rightBoundStart) {
                leftInterval.right = rightIndex;
            } else if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
                leftInterval.right = rightInterval.right;
                rangeList.remove(rightInterval);
            }
//            } else if (rightIndex == rightBoundEnd) {
//
//            }
        } else if (leftIndex >= leftBoundEnd && leftIndex < rightBoundStart) {
            if (rightIndex >= leftBoundEnd && rightIndex < rightBoundStart) {
                if (leftIndex == leftBoundEnd) {
                    leftInterval.right = rightIndex;
                } else {
                    rangeList.add(rangeList.indexOf(leftInterval) + 1, range);
                }
            } else if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
                rightInterval.left = leftBoundStart;
            }
        }
//            } else if (rightIndex == rightBoundEnd) {}
//        } else if (leftIndex >= rightBoundStart && leftIndex < rightBoundEnd) {
//            if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
//                rightInterval.left = leftBoundStart;
//            }
//            } else if (rightIndex == rightBoundEnd) {}
//        } else if (leftIndex == rightBoundEnd) {
//
//        }
    }

    private boolean remove(Range range) {
        for (Range r : rangeList) {
            if(r.left == range.left && r.right == range.right) {
                rangeList.remove(range);
                return true;
            }
        }
        return false;
    }

    void print() {
        for (Range r : rangeList) {
            System.out.println("[" + r.left + "," + r.right +")");
        }
    }

    public static void main(String[] args) {
        RangeList rl = new RangeList();
        Range r1 = new Range();
        r1.left = 1;
        r1.right = 5;

        Range r2 = new Range();
        r2.left = 10;
        r2.right = 20;

        Range r3 = new Range();
        r3.left = 20;
        r3.right = 20;
        rl.add(r1);
        rl.print();

        rl.add(r2);
        rl.print();

        rl.add(r3);
        rl.print();
    }
}

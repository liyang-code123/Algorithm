//package ov;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class RangeList {
//    static class Range {
//        int left;
//        int right;
//
//        public Range(int left, int right) {
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    List<Range> rangeList = new ArrayList<>();
//
//    private void add(Range range) {
//        if (range == null || range.left >= range.right) {
//            return;
//        }
//
//        if (rangeList.isEmpty()) {
//            rangeList.add(range);
//            return;
//        }
//
//        int leftInterval = binarySearch(rangeList, range.left);
//        int rightInterval = binarySearch(rangeList, range.right);
//
//        //merge(rangeList, leftInterval, rightInterval, range.left, range.right, range);
//        merge(leftInterval, rightInterval, range);
//    }
//
//    private int binarySearch(List<Range> rangeList, int target) {
//        int left = 0;
//        int right = rangeList.size() - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (rangeList.get(mid).left == target) {
//                return mid;
//            } else if (rangeList.get(mid).left  > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right + 1;
//    }
//
//    private void merge(int leftIndex, int rightIndex, Range range) {
//        int size = rangeList.size();
//
//        if (leftIndex == 0) {
//            if (rightIndex == 0) {
//                if (range.right == rangeList.get(0).left) {
//                    rangeList.get(0).left = range.left;
//                } else {
//                    rangeList.add(0, range);
//                }
//            } else if (rightIndex == size) {
//                 if (range.right < rangeList.get(size - 1).right) {
//                     int right = rangeList.get(size - 1).right;
//                     rangeList.clear();
//                     rangeList.add(new Range(range.left, right));
//                 } else {
//                     rangeList.clear();
//                     rangeList.add(range);
//                 }
//            } else {
//
//
//            }
//
//        } else if (leftIndex == size){
//            if (range.left <= rangeList.get(size - 1).right) {
//                if (range.right > rangeList.get(size - 1).right) {
//                    rangeList.get(size - 1).right = range.right;
//                }
//            } else {
//                rangeList.add(range);
//            }
//        } else {
//
//        }
//    }
//
//    private void merge(List<Range> rangeList, int leftInterval, int rightInterval, int leftIndex, int rightIndex, Range range) {
//        int leftBoundStart = leftInterval.left;
//        int leftBoundEnd = leftInterval.right;
//        int rightBoundStart = rightInterval.left;
//        int rightBoundEnd = rightInterval.right;
//        if (leftIndex >= leftBoundStart && leftIndex < leftBoundEnd) {
////            if (rightIndex >= leftBoundStart && rightIndex < leftBoundEnd) {
////                continue;
////            } else
//            if (rightIndex >= leftBoundEnd && rightIndex < rightBoundStart) {
//                leftInterval.right = rightIndex;
//            } else if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
//                leftInterval.right = rightInterval.right;
//                rangeList.remove(rightInterval);
//            }
////            } else if (rightIndex == rightBoundEnd) {
////
////            }
//        } else if (leftIndex >= leftBoundEnd && leftIndex < rightBoundStart) {
//            if (rightIndex >= leftBoundEnd && rightIndex < rightBoundStart) {
//                if (leftIndex == leftBoundEnd) {
//                    leftInterval.right = rightIndex;
//                } else {
//                    rangeList.add(rangeList.indexOf(leftInterval) + 1, range);
//                }
//            } else if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
//                rightInterval.left = leftBoundStart;
//            }
//        }
////            } else if (rightIndex == rightBoundEnd) {}
////        } else if (leftIndex >= rightBoundStart && leftIndex < rightBoundEnd) {
////            if (rightIndex >= rightBoundStart && rightIndex <= rightBoundEnd) {
////                rightInterval.left = leftBoundStart;
////            }
////            } else if (rightIndex == rightBoundEnd) {}
////        } else if (leftIndex == rightBoundEnd) {
////
////        }
//    }
//
//    private boolean remove(Range range) {
//        for (Range r : rangeList) {
//            if(r.left == range.left && r.right == range.right) {
//                rangeList.remove(range);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    void print() {
//        for (Range r : rangeList) {
//            System.out.println("[" + r.left + "," + r.right +")");
//        }
//    }
//
//    public static void main(String[] args) {
//        RangeList rl = new RangeList();
//        Range r1 = new Range();
//        r1.left = 1;
//        r1.right = 5;
//
//        Range r2 = new Range();
//        r2.left = 10;
//        r2.right = 20;
//
//        Range r3 = new Range();
//        r3.left = 20;
//        r3.right = 20;
//        rl.add(r1);
//        rl.print();
//
//        rl.add(r2);
//        rl.print();
//
//        rl.add(r3);
//        rl.print();
//    }
//}

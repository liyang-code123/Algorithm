package AmazonOA;

// AmazonOA: Memory consumption. Similar to two sum less than k.
/* 1099 two sum less than k变种. 题目是memory consumption分配, front end && back end用的小于K, 附上地里类似面经的链接
https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=476881&ctid=228990

有两个数组 如下形式, 每个代表一个application, 第一个数代表index, 代表application会使用的内存
[[1, 100], [2, 200], [3, 500] ...]
[[1, 200], [2, 300], [3, 900] ...]
给一个最大的Memory数例如1000
从第一和第二个数组中个找出一个application 总内存小于1000
这个题的答案是[3, 2], 既取第一个array中的3, 500和第二个array中的2, 300 总共用800 memory < 1000

有同学问思路, 思路就是双指针 第一个头 第二个尾 第一个右移 第二个左移

补充一下第一题 就是K Nearest City的题目 二维坐标的city 找出K个最近的 用priority_queue做

https://www.1point3acres.com/bbs/thread-696651-2-1.html
*/

public class MemoryConsumption {
    public int sumTwo(int[][] a, int[][] b, int target) {
        if (a == null || b == null) return -1;
        int[] aValue = new int[a.length];
        int[] bValue = new int[b.length];
        for (int[] A : a) {
            for (int i = 0; i < a.length; i++) {
                aValue[i] = A[1];
            }
        }
        for (int[] B : b) {
            for (int i = 0; i < b.length; i++) {
                bValue[i] = B[1];
            }
        }

        int i = 0, j = b.length - 1;
        int sum = -1;
        while (i < a.length && j >= 0) {
            if (aValue[i++] + bValue[j--] < target) {
                sum = Math.max(sum, aValue[i] + bValue[j]);
            }
            i++;
            j--;
        }
        return sum;
    }

    public static void main(String[] args) {
        MemoryConsumption test = new MemoryConsumption();
        int[][] a = {{1, 2, 3}, {100, 200, 300}};
        int[][] b = {{1, 2, 3}, {200, 300, 900}};
        int target = 1000;
        System.out.println(test.sumTwo(a, b, target));
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public int minimumMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] meeting : meetings) {
            if (!queue.isEmpty() && queue.peek()[1] <= meeting[0]) {
                queue.poll();
            }
            queue.offer(meeting);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        MeetingRoomII test = new MeetingRoomII();
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(test.minimumMeetingRooms(meetings));
    }
}

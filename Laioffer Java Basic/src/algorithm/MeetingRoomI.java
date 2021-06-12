import java.util.Arrays;

public class MeetingRoomI {

    /* Solution 1 */
//    public boolean canAttendMeeting(int[][] meetings) {
//        for (int i = 0; i < meetings.length; i++) {
//            for (int j = i + 1; j < meetings.length; j++) {
//                if(overlap(meetings[i], meetings[j])) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean overlap(int[] meeting1, int[] meeting2) {
//        return (meeting2[0] > meeting1[0] && meeting2[0] < meeting1[1])
//                || (meeting1[0] > meeting2[0] && meeting1[0] < meeting2[1]);
//    }

    /* Solution 2 */
    public boolean canAttendMeeting(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][1] < meetings[i - 1][1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        MeetingRoomI test = new MeetingRoomI();
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(test.canAttendMeeting(meetings));
    }
}

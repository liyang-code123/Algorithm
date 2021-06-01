// LeetCode 165
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int i1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int i2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (i1 != i2) {
                return i1 < i2 ? -1 : 1;
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        System.out.println(test.compareVersion(version1, version2));
    }
}

import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/8/31
 */
public class CorpFlightBookings {

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] tmpArr = bookings[i];
            int start = tmpArr[0];
            int end = tmpArr[1];
            int num = tmpArr[2];
            for (int j = start-1; j < end; j++) {
                result[j] += num;
            }
        }
        return result;
    }

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] tmpArr = bookings[i];
            int start = tmpArr[0];
            int end = tmpArr[1];
            int num = tmpArr[2];
            result[start - 1] += num;
            if (end < n){
                result[end] -= num;
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] += result[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        int[] ints = corpFlightBookings(nums, n);
        System.out.println(Arrays.toString(ints));

    }
}

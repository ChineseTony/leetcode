/**
 * @author wangtao
 * @date 2021/8/29
 */
public class SumOddLengthSubarrays {

    public static int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        if(arr == null || arr.length == 0){
            return result;
        }
        int len = arr.length;
        int[] sum = new int[len+1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }
        for (int i = 1; i <= len ; i+=2) {
            for (int j = 0; j+i<len ; j++) {
                result+=sum[j+i]-sum[j];
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}

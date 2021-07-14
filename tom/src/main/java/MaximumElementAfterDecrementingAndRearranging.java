import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/7/15
 */
public class MaximumElementAfterDecrementingAndRearranging {


    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr == null || arr.length <= 0){
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length;
        arr[0]= 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i-1] > 1){
                arr[i] = arr[i-1] + 1;
            }
        }
        if (arr[len-1] > len){
            return len;
        }else {
            return arr[len-1];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,1,1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(nums));

    }
}

import java.util.Arrays;

/**
 * @author tomsun28
 * @date 2021/7/16 0:10
 */
public class MaximumElement {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 1;
        int pre = 1;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - pre;
            if (diff > 1) {
                max = pre + 1;
                pre = max;
            } else {
                max = arr[i];
                pre = arr[i];
            }
        }
        return max;
    }
}

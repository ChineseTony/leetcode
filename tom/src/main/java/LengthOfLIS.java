import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2021/8/30
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] dp = new int[nums.length+1];
        dp[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]){
                dp[++len] = nums[i];
            }else {
                int left = 1;
                int right = len;
                int pos = 0;
                while (left <= right){
                    int mid = (right - left)/ 2 + left;
                    if (dp[mid] < nums[i]){
                        pos = mid;
                        left = mid + 1;
                    }else {
                        right = mid-1;
                    }
                }
                dp[pos+1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int[] nums = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS2(nums));

    }
}

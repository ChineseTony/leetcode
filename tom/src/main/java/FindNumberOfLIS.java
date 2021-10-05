

/**
 * @author wangtao
 * @date 2021/10/5
 */
public class FindNumberOfLIS {


    public static int lengthOfLIS(int[] nums) {
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
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(lengthOfLIS(nums));
    }
}

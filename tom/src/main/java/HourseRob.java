/**
 * @author wangtao
 * @date 2021/10/6
 */
public class HourseRob {

    public static int rob(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i <= len ; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[len-1];
    }

    public static int rob2(int[] nums){
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }else if (len == 2){
            return Math.max(nums[0],nums[1]);
        }else {
            return Math.max(cal(nums,0,len-2),
                    cal(nums,1,len-1));
        }
    }

    private static int cal(int[] nums,int start,int end){
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob2(nums));
    }
}

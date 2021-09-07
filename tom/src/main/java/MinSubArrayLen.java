/**
 * @author wangtao
 * @date 2021/9/7
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int index  = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
                int tmp  = i - index + 1;
                result = Math.min(tmp,result);
                sum -= nums[index++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/9/3
 * @link https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {

    private static Map<String,Boolean> map = new HashMap<>();

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i:nums){
            sum +=i;
        }
        if (sum % 2 != 0){
            return false;
        }
        Arrays.sort(nums);
        return equalsSubSet(nums,
                0,0,sum/2);
    }

    private static boolean equalsSubSet(int[] nums,int index,
                                        int sum,int target){
        if (index >= nums.length){
            return false;
        }
        if (sum > target){
            return false;
        }
        if (sum == target){
            return true;
        }
        boolean flag = false;
        for (int j = index; j < nums.length; j++) {
            if (sum + nums[j] > target ){
                continue;
            }
            String key = (j+1) + "&" + (sum + nums[j]);
            if (map.containsKey(key)){
                flag = map.get(key);
            }else {
                flag = equalsSubSet(nums, j + 1, sum + nums[j], target);
                map.put(key,flag);
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }


    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i:nums){
            sum +=i;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < len ; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition2(nums));
    }
}

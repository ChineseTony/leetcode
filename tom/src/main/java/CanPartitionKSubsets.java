import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/10/5
 */
public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i:nums){
            sum += i;
        }
        if (sum % k != 0){
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        if(nums[nums.length - 1] > sum){
            return false;
        }
        int[] tmp = new int[k];
        Arrays.fill(tmp,sum);
        return help(nums, nums.length - 1, tmp, k);
    }

    private boolean help(int[] nums,int index,int[] tmp,int k){
        if (index < 0){
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (tmp[i] == nums[index] ||
                    (index > 0 && tmp[i] - nums[index] >= nums[0])){
                tmp[i] -= nums[index];
                if(help(nums, index - 1, tmp, k)){
                    return true;
                }
                tmp[i] += nums[index];
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(new CanPartitionKSubsets().canPartitionKSubsets(nums,k));
    }
}

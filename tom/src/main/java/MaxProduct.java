import java.util.Arrays;

/**
 * @author wangtao
 * @date 2022/8/27
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 1){
            return -1;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-1] * nums[len-2];
    }

    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length <= 1){
            return -1;
        }
        int maxNumber = nums[0] > nums[1] ? 0 : 1;
        int secondMaxNumber = nums[0] < nums[1] ? 0 : 1;
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            int tmpNumber = nums[i];
            if(tmpNumber > nums[maxNumber]){
                secondMaxNumber = maxNumber;
                maxNumber = i;
            }else if(tmpNumber > nums[secondMaxNumber]){
                secondMaxNumber = i;
            }
        }
        return (nums[maxNumber] - 1) * (nums[secondMaxNumber] -1);
    }
}

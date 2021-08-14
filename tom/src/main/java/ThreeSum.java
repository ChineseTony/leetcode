import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/14
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2){
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    while (left < right && nums[left] == nums[left+1] ){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> tmp:lists){
            System.out.println(Arrays.toString(
                    tmp.toArray(new Integer[0])
            ));
        }

    }
}

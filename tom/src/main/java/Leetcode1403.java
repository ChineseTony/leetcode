import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/8/4
 */
public class Leetcode1403 {

    public static List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{4,3,10,9,8};
        List<Integer> integers = minSubsequence(nums);
        System.out.println(Arrays.toString(integers.toArray(new Integer[0])));

    }
}

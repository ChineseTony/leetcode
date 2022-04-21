import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/4/21
 * @link https://leetcode-cn.com/problems/QTMn0o/
 */
public class SubarraySum {

    public static int subarraySum1(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0 ;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k){
                    result ++;
                }
            }
        }
        return result;
    }


    public static int subarraySum2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        map.put(0,1);
        int pre = 0;
        int result= 0;
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            result += map.getOrDefault(pre-k,0);
            map.put(pre,map.getOrDefault(pre,0) + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        // 1 3 4
        int k = 3;
        System.out.println(subarraySum1(nums,k));
        System.out.println(subarraySum2(nums,k));
    }
}

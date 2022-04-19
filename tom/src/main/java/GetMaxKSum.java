import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/4/19
 */
public class GetMaxKSum {

    //1.暴力循环遍历所有子序列和 求出和为k的子序列
    public static int getMaxKSum(int[] nums,int k){
        int tmp = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len ; j++) {
                sum += nums[j];
                if (sum == k){
                    tmp = Math.max(tmp,j-i+1);
                }
            }
        }
        return tmp;
    }

    public static int getMaxKSum2(int[] nums,int k){
        int len= nums.length;
        Map<Integer,Integer> map = new HashMap<>(len);
        map.put(0,-1);
        int sum = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                result = Math.max(result,i - map.get(sum - k) );
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(getMaxKSum(nums,k));
        nums = new int[]{-2, -1, 2, 1};
        k = 1;
        System.out.println(getMaxKSum(nums,k));

        nums = new int[]{1, -1, 5, -2, 3};
        k = 3;
        System.out.println(getMaxKSum2(nums,k));
        nums = new int[]{-2, -1, 2, 1};
        k = 1;
        System.out.println(getMaxKSum2(nums,k));
    }
}

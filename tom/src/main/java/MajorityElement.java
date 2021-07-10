import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/7/10
 * @link https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>(len);
        for (int i:nums){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue() >  len / 2){
                return entry.getKey();
            }
        }
        return -1;
    }


    public static int majorityElement2(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int len = nums.length;
        int a = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (a == nums[i]){
                count++;
            }else {
                count--;
            }
            if (count < 0){
                a = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int i:nums){
            if (a == i){
                count ++ ;
            }
        }
        return count * 2 >  len ? a : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));

    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @author wangtao
 * @date 2022/9/19
 */
public class Leetcode1636 {

    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i:nums){
            if (!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,map.get(i) + 1);
            }
        }
        Integer[] tmp=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))){
                return o2.compareTo(o1);
            }else {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
        return nums;
    }

}

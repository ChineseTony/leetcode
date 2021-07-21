/**
 * @author wangtao
 * @date 2021/7/16
 */
public class Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int count = 0;
        for (int i:nums){
            if (i == target){
                count++;
            }
        }
        return count;
    }


}

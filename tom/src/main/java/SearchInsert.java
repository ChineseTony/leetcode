/**
 * @author wangtao
 * @date 2021/8/23
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (target > nums[len-1]){
            return len;
        }
        int left = 0;
        int right = len-1;
        while (left < right){
            int mid = (right + left) / 2;
            if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}

/**
 * @author wangtao
 * @date 2021/8/23
 */
public class SearchNumber {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (right + left ) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[left]){
                if (target >= nums[left]
                && target <= nums[mid]){
                    right = mid-1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }
}

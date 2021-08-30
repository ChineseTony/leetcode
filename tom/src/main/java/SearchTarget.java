/**
 * @author wangtao
 * @date 2021/8/30
 */
public class SearchTarget {


    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return false;
        }
        if (len == 1){
            return nums[0] == target;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] == nums[left] && nums[right] == nums[mid]){
                left++;
                right--;
            }else if (nums[left] <= nums[mid]){
                if (  nums[left] <= target && target < nums[mid]){
                    right = mid - 1 ;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[len-1]){
                    left = mid +1 ;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,1,1,1};
        System.out.println(search(nums,0));

    }
}

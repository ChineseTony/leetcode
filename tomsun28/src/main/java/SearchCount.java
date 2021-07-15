/**
 * @author tomsun28
 * @date 2021/7/16 0:21
 */
public class SearchCount {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        Integer index = null;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int count = 0;
        if (index != null) {
            count++;
            high = index + 1;
            while(high < nums.length && nums[high] == target) {
                count++;
                high++;
            }
            low = index - 1;
            while(low >= 0 && nums[low] == target) {
                count++;
                low--;
            }
        }
        return count;
    }
}

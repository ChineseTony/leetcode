import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/8/3
 */
public class FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int[] tmpArray = new int[len];
        System.arraycopy(nums,0,tmpArray,0,len);
        Arrays.sort(tmpArray);
        int left = 0;
        int right = len-1;
        while (left < right) {
            if (tmpArray[left] == nums[left]) {
                left++;
            }
            if (tmpArray[right] == nums[right]) {
                right--;
            }
            if (tmpArray[left] != nums[left] && tmpArray[right] != nums[right]){
                break;
            }
        }
        if (right == left){
            return 0;
        }else {
            return right - left + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
        nums = new int[]{1,2,3,3,3,3,3,4};
        System.out.println(findUnsortedSubarray(nums));
    }
}

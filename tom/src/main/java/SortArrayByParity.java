import java.util.Arrays;

/**
 * @author wangtao
 * @date 2022/4/29
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            while (left < right && isEven(nums[left])){
                left++;
            }
            while (left < right && !isEven(nums[right])){
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }

    private static boolean isEven(int num){
        return  num % 2 == 0;
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 4};
        int[] ints = sortArrayByParity(nums);
        System.out.println(Arrays.toString(ints));
    }
}

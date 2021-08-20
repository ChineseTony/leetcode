/**
 * @author wangtao
 * @date 2021/8/20
 */
public class NumArray {

    private int[] tmpArray;

    public NumArray(int[] nums) {
        tmpArray = new int[nums.length];
        //求前缀和
        int sum = nums[0];
        tmpArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            tmpArray[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0){
            return tmpArray[right];
        }
        return tmpArray[right] - tmpArray[left-1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(0,2));

    }
}

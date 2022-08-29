/**
 * @author wangtao
 * @date 2022/8/29
 */
public class Shuffle {

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[2*i ] = nums[i];
            result[2*i + 1] = nums[i+n];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,1,3,4,7};
        int n = 3;
        int[] shuffle = shuffle(nums, n);
        for (int i:shuffle){
            System.out.print(i+" ");
        }
    }
}

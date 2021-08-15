/**
 * @author wangtao
 * @date 2021/8/15
 */
public class FindK {

    public static int findK(int[] nums,int k){
        return findK(nums,0,nums.length-1,k);
    }

    private static int findK(int[] nums,int left,int right,int k){
        int low = left;
        int high = right;
        int tmp = nums[low];
        while (low < high){
            while (low < high && nums[high] <= tmp){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] >= tmp){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = tmp;
        if (high == k -1){
            return tmp;
        }else if (high > k-1){
            return findK(nums,left,high-1,k);
        }else {
            return findK(nums,high+1,right,k);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,0};
        System.out.println(findK(nums,4));
    }
}

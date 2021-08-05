/**
 * @author wangtao
 * @date 2021/8/5
 */
public class ReversePairs {

    public  int  reversePairs(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i] > nums[j]){
                    count++;
                }
            }
        }

        return count;

    }

    public  int  reversePairs2(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        sort(nums);
        return count;
    }

    private static int[] tmpArr;

    private static int count;

    private void sort(int[] nums){
        tmpArr = new int[nums.length];
        count = 0;
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums,int left,int right){
        if (left < right){
            int mid = (right - left) / 2 + left;
            sort(nums,left,mid);
            sort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private void merge(int[] nums,int left,int mid,int right){
        int i = mid;
        int j = right;
        int tmp = right;
        int tmpCount = 0;
        while (i >= left && j >= mid+1){
            if (nums[i] > nums[j]){
                tmpCount = j - mid;
                count += tmpCount;
                tmpArr[tmp--] = nums[i--];
            }else {
                tmpArr[tmp--] = nums[j--];
            }
        }
        while (i >= left){
            tmpArr[tmp--] = nums[i--];
        }
        while (j >= mid+1){
            tmpArr[tmp--] = nums[j--];
        }

        int v = right;
        while (v >= left){
            nums[v] = tmpArr[v];
            v--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        System.out.println(new ReversePairs().reversePairs2(nums));

    }
}

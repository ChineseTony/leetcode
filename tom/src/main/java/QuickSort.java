/**
 * @author wangtao
 * @date 2021/8/15
 */
public class QuickSort {

    public void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums,int left,int right){
        if (left < right){
            int partition = partition(nums,left,right);
            sort(nums,left,partition-1);
            sort(nums,partition+1,right);
        }
    }

    public int partition(int[] nums,int left,int right){
        int low = left;
        int high = right;
        int tmp = nums[low];
        while (low < high){
            while (low < high && nums[high] >= tmp){
                high --;
            }
            swap(nums,low,high);
            while (low < high && nums[low] <= tmp){
                low++;
            }
            swap(nums,low,high);
        }
        nums[low] = tmp;
        return low;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{19,-1,23,4};
        new QuickSort().sort(nums);
        for (int i:nums){
            System.out.print(i+"\t");
        }
    }
}

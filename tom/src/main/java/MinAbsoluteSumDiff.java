import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/7/14
 */
public class MinAbsoluteSumDiff {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        final int MOD = 1000000007;
        int[] arr = new int[n];
        System.arraycopy(nums1,0,arr,0,n);
        int sum = 0,maxn = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(arr, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (arr[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - arr[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;

    }

    private int binarySearch(int[] rec,int target){
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {

    }
}

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author tomsun28
 * @date 2021/7/14 8:19
 */
public class MinimumSumDifference {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int result = 0;
        TreeMap<Integer, Integer> indexMap = new TreeMap<>(Comparator.comparingInt(item -> item));
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            result = (diff + result) % (1000000000 + 7) ;
            indexMap.put(nums1[i], i);
        }
        int finalv = result;
        for (int i = 0; i < nums1.length; i++) {
            int index2Value = nums2[i];
            Integer tmp1 = indexMap.floorKey(index2Value);
            Integer tmp2 = indexMap.ceilingKey(index2Value);
            int tmp3 = 0;
            if (tmp1 == null) {
                tmp3 = Math.abs(tmp2 - index2Value);
            } else if(tmp2 == null) {
                tmp3 = Math.abs(tmp1 - index2Value);
            } else {
                tmp3 = Math.min(Math.abs(tmp1 - index2Value), Math.abs(tmp2 - index2Value)) ;
            }
            if (tmp3 < Math.abs(nums1[i] - nums2[i])) {
                result = Math.min(result, (finalv + 1000000007 - (Math.abs(nums1[i] - nums2[i]) - tmp3)) % 1000000007);
            }
        }
        return result;
    }
}

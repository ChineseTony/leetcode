import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/10/23
 */
public class Leetcode350 {


    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int p = 0;
        int q = 0;
        int k = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (p < len1 && q < len2){
            if (nums1[p] < nums2[q]){
                p++;
            }else if (nums1[p] > nums2[q]){
                q++;
            }else{
                result.add(nums1[p]);
                p++;
                q++;
            }
        }
        int len = result.size();
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = result.get(i);
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        Leetcode350 leetcode350 = new Leetcode350();
        System.out.println(Arrays.toString(leetcode350.intersect(nums1,nums2)));
    }
}

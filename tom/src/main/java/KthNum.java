/**
 * @author wangtao
 * @date 2021/8/20
 */
public class KthNum {


    public static int getKthNum(int[] nums1,int[] nums2,int k){
        int p = 0;
        int q = 0;
        int result = -1;
        if (k > nums1.length + nums2.length){
            return -1;
        }
        while (p < nums1.length && q < nums2.length){
            k--;
            if (nums1[p] < nums2[q]){
                if (k == 0){
                    result = nums1[p];
                    return result;
                }
                p++;
            }else{
                if (k == 0){
                    result = nums2[q];
                    return result;
                }
                q++;
            }

        }
        while (k  >= 0 && p < nums1.length){
            k--;
            if (k == 0){
                result = nums1[p];
                return result;
            }
            p++;
        }
        while (k  >= 0 && q < nums2.length){
            k--;
            if (k == 0){
                result = nums2[q];
                return result;
            }
            q++;

        }
        return result;
    }


    public static int getKthNum2(int[] nums1,int[] nums2,int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        if (k > len1 + len2){
            return -1;
        }
        while (true){
            if (index1 == len1){
                return nums2[index2 + k -1];
            }
            if (index2 == len2){
                return  nums1[index1+k -1];
            }
            if (k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{6,7,8,9};
        int[] nums2 = new int[]{2,3,4,5};
        int k = 9;
        System.out.println(getKthNum(nums1,nums2,k));
        System.out.println(getKthNum2(nums1,nums2,k));
    }
}

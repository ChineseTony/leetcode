/**
 * @author wangtao
 * @date 2021/8/5
 * 归并排序
 */
public class MergerSort {

    private static int[] tmp;


    public static void sort(int[] arr){
        tmp = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] array,int left,int right){
        if (left < right){
            int mid = (right - left)/ 2 + left;
            sort(array,left,mid);
            sort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    /**
     * 把2个数组归并为有序数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr,int left,int mid,int right){
        int i = 0;
        int tmpLeft = left;
        int tmpRight = mid+1;
        while (tmpLeft <= mid && tmpRight <= right){
            if (arr[tmpLeft] < arr[tmpRight]){
                tmp[i++] = arr[tmpLeft++];
            }else {
                tmp[i++] = arr[tmpRight++];
            }
        }
        while (tmpLeft <= mid){
            tmp[i++] = arr[tmpLeft++];
        }
        while (tmpRight <= right){
            tmp[i++] = arr[tmpRight++];
        }
        i = 0;
        while(left <= right){
            arr[left++] = tmp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,50,-12};
        MergerSort.sort(nums);
        for (int i:nums){
            System.out.print(i + "\t");
        }

    }
}

/**
 * @author wangtao
 * @date 2022/5/15
 */
public class SearchArr {
    public static int search(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int search2(int[] arr, int target) {
        int left = 0;
        int len = arr.length;
        int right = len - 1;
        int mid = 0;
        if(arr[0]==target) {
            return 0;
        }
        while (left <= right){
            mid = (right - left) / 2 + left;
            if (arr[mid] == target){
                while (mid > 0 && arr[mid] == arr[mid-1]){
                    mid--;
                }
                return mid;
            }
            if (arr[mid] < arr[right]){
                if (arr[mid] < target && target <= arr[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else if (arr[mid] > arr[right]){
                if (arr[left] <= target && target < arr[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                right--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,5,1,2,3,4,5,5};
        int   target = 5;
        System.out.println(search(arr,target));
        System.out.println(search2(arr,target));
    }


}

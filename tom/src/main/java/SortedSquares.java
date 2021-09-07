/**
 * @author wangtao
 * @date 2021/9/7
 */
public class SortedSquares {

    public int[] sortedSquares(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int[] result = new int[arr.length];
        int index = arr.length-1;
        while (left <= right){
            if (arr[left] * arr[left] > arr[right] * arr[right]){
                result[index--] = arr[left] * arr[left];
                left++;
            }else {
                result[index--] = arr[right] * arr[right];
                right--;
            }
        }
        return  result;
    }
}

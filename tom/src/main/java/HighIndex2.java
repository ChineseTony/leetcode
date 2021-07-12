/**
 * @author wangtao
 * @date 2021/7/12
 */
public class HighIndex2 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0){
            return -1;
        }
        int i = 0;
        while (i < citations.length &&
                citations[citations.length - i - 1] > i){
            i++;
        }
        return i;
    }

    public int hIndex2(int[] citations) {
        int idx = 0, n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == n - pivot) {
                return n - pivot;
            } else if (citations[pivot] < n - pivot){
                left = pivot + 1;
            } else{
                right = pivot - 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {

    }
}

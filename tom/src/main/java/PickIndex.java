import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/8/30
 */
public class PickIndex {
    private int total;
    private int[] preSum;

    public PickIndex(int[] w) {
        int len = w.length;
        preSum = new int[len+1];
        preSum[0] = w[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int  x =(int) (Math.random() * total) + 1;
        int result = searchIndex(x);
        return result;
    }

    private int searchIndex(int x){
        for (int i = 0; i < preSum.length; i++) {
            if (x <= preSum[i]){
                return i;
            }
        }
        return -1;
    }

    private int searchIndex2(int x){
        int left = 0;
        int right = preSum.length-1;
        while (left < right){
            int mid = (right - left) / 2+ left;
            if (preSum[mid] < x){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}

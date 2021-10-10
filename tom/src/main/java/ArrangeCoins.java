/**
 * @author wangtao
 * @date 2021/10/10
 */
public class ArrangeCoins {

    public static int arrangeCoins(int n) {
        int i = 1;
        int count = 0;
        while (n > 0){
            n -= i;
            i++;
            count++;
        }
        return n == 0 ? count : count -1;
    }

    public int arrangeCoins2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

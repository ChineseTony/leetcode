/**
 * @author wangtao
 * @date 2022/5/19
 *
 * @link https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class FindKthNumberNM {

/*
    1	2	3
    2	4	6
    3	6	9
 */
    public static int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int count = 0;
        while (left < right){
            int mid = (right - left) / 2 + left;
            count = mid / n * n;
            for (int i = mid / n + 1; i <= m; ++i) {
                count += mid / i;
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
       int m = 3, n = 3, k = 5;
        System.out.println(findKthNumber(m, n, k));
    }
}

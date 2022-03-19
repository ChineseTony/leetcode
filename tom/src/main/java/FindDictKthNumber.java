import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/3/19
 *
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDictKthNumber {

    public static int findKthNumber2(int n, int k) {
        List<String> all = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            all.add(i+"");
        }
        all.sort(String::compareTo);

        return  Integer.parseInt(all.get(k-1));
    }

    public static int findKthNumber(int n, int k) {
        long cur = 1;
        int tmp = k -1;
        while (tmp > 0){
            long step = stepCount(cur,n);
            if (step > tmp){
                cur *= 10;
                tmp--;
            }else {
                cur += 1;
                tmp -= step;
            }
        }
        return  (int)cur;
    }

    private static long stepCount(long cur,int n){
        long tmp = cur;
        long next = tmp+1;
        long sum = 0;
        while (cur <= n){
            sum += Math.min(n - cur + 1,next - cur);
            cur *= 10;
            next *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 12;
        int k = 3;
        System.out.println(findKthNumber(n,k));

    }



}

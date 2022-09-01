import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2022/9/1
 */
public class Leetcode1475 {


//    输入：prices = [8,4,6,2,3]
//    输出：[4,2,4,2,3]
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8,4,6,3,2};
        int[] result = finalPrices(prices);
        for (int i:result){
            System.out.print(i + " ");
        }

    }
}

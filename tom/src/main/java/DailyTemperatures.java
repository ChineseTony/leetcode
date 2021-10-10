import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2021/10/10
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int tmpValue = temperatures[i];
            if (!stack.isEmpty() && tmpValue >= temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < tmpValue) {
                    result[stack.peek()] = i - stack.pop();
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(tmp);
        for (int i:ints){
            System.out.print(i+" ");
        }

    }
}

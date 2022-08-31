import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2022/8/31
 */
public class Leetcode946 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length){
            return false;
        }
        int i = 0;
        int j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < pushed.length){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        return j == popped.length;
    }


    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
        popped = new int[]{4,5,3,1,2};
        System.out.println(validateStackSequences(pushed, popped));
    }


}

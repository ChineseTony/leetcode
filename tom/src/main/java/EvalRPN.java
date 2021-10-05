import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2021/10/4
 */
public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0){
            return 0;
        }
        int len = tokens.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            String tmp = tokens[i];
            if ("+".equals(tmp)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }else if ("-".equals(tmp)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if ("*".equals(tmp)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }else if ("/".equals(tmp)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else {
                stack.push(Integer.valueOf(tmp));
            }
        }
        return stack.peek();
    }




    public static void main(String[] args) {
        String[] tokens = new String[]{
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };
        System.out.println(evalRPN(tokens));

    }
}

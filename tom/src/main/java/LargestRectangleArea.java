import java.util.Stack;

/**
 * @author wangtao
 * @date 2021/10/3
 */
public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0){
            return 0;
        }
        int len = heights.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int index = stack.pop();
                int height = heights[index];
                int l = stack.isEmpty() ? -1 : stack.peek();
                int r = i - 1;
                ans = Math.max(ans, (r - l) * height);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = heights[index];
            int l = stack.isEmpty() ? -1 : stack.peek();
            int r = len - 1;
            ans = Math.max(ans, (r - l) * h);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}

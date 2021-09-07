import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/9/7
 */
public class GetSumLessZeroMaxLen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Queue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            sum += tmp;
            count++;
            if (arr[i] < 0) {
                queue.offer(tmp);
                while (sum < 0 && !queue.isEmpty()) {
                    Integer poll = queue.poll();
                    count--;
                    sum = sum - poll;

                }
            }
        }
        System.out.println(count);
    }


    /**
     * 判断 数字是不是可以通过 11 111 1111 ...累加得到
     * @param i
     * @return
     */
    private static boolean isValid(int i){
        int b = i % 11;
        i -= b * 111;
        if (i >=0 && i % 11 == 0){
            return true;
        }else {
            return false;
        }
    }
}

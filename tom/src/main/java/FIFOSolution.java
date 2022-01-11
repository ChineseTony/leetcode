import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wangtao
 * @date 2021/10/30
 */
public class FIFOSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> sets = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if (queue.isEmpty() || (queue.size() < m && !sets.contains(tmp))){
                queue.add(tmp);
                sets.add(tmp);
                count++;
            }else if (!sets.contains(tmp)){
                int tmpValue = queue.poll();
                sets.remove(tmpValue);
                queue.offer(tmp);
                count++;
            }
        }
        System.out.println(count);
    }
}

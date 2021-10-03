import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/10/3
 *
 * todo 螺旋数组填充
 */
public class LuoXuanArray {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int i = 10;
        int  n = getA(i);
        int[][] array = new int[n][n];
        luoxuan(array,i);

    }

    public static void luoxuan(int[][] array,int k){

    }


    private static int getA(int n){
        int i = 1;
        while (i * i < n){
            i = i + 1;
        }
        return i;
    }


    public int getMaxLen(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int arrLen = array.length;
        for (int i = 0; i < arrLen; i++) {
            if (stack.isEmpty() || stack.peek() < array[i]){
                stack.offer(array[i]);
            }else {

            }
        }
        return 0;
    }
}

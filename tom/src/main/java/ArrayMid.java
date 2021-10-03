import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wangtao
 * @date 2021/10/3
 * 找无序数组 中位数
 */
public class ArrayMid {


    public static int getMid(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        int len = array.length;
        if (len % 2 == 1){
            return array[len / 2];
        }else {
            return (array[len/2] + array[len/2 - 1]) / 2;
        }
    }

    public static int getMid2(int[] array){
        if (array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        int heapSize = len / 2 + 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            queue.offer(array[i]);
        }
        for (int i = heapSize; i < len; i++) {
            if (array[i] > queue.peek()){
                queue.poll();
                queue.offer(array[i]);
            }
        }
        if (len % 2 == 1){
            return queue.peek();
        }else {
            return (queue.poll()+ queue.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,4,4,7,-1};
        System.out.println(getMid(arr));
        System.out.println(getMid2(arr));
    }

}

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2022/7/16
 */
public class Leetcode41 {

    class MovingAverage {
        private int size = 0;
        private double sum = 0;

        private Queue<Integer>  queue;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<>(size);
        }

        public double next(int val) {
            if (!queue.isEmpty() && queue.size() ==  size){
                int tmp = queue.poll();
                sum = sum - tmp ;
            }
            sum = sum + val;
            queue.offer(val);
            return sum / queue.size();
        }
    }


    public static void main(String[] args) {

    }
}

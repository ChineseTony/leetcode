import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2021/8/9
 */
public class GetMaxAndNextNumber {

    public static int[] getMax(int[] nums){
        int len = nums.length;
        int[] result = new int[2];
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            if (queue.size() < 2){
                queue.offer(nums[i]);
            }else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        int i = 0;
        while (!queue.isEmpty()){
            result[i++] = queue.poll();
        }
        return result;
    }

    public static int[] getMaxNums(int[] nums){
        if (nums == null || nums.length <= 0){
            return nums;
        }
        int maxValue = Integer.MIN_VALUE;
        int nextMaxValue = Integer.MIN_VALUE;
        int[] result = new int[2];
        int len = nums.length;
        //获取最大的数的下标
        for (int i = 0; i < len; i++) {
            // 比最大数大
            if (nums[i] > maxValue){
                nextMaxValue = maxValue;
                maxValue = nums[i];
            }else if (nums[i] > nextMaxValue && nums[i] < maxValue){
                nextMaxValue = nums[i];
            }
        }
        result[0] = maxValue;
        result[1] = nextMaxValue;
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,0,0,-8};
        int[] max = getMaxNums(nums);
        for (int i:max){
            System.out.print(i+"\t");
        }

    }
}

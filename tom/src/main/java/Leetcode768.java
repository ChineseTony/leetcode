import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/8/13
 */
public class Leetcode768 {

    public static int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        Map<Integer,Integer> map = new HashMap<>(len);
        int[] tmpArr = new int[arr.length];
        System.arraycopy(arr,0,tmpArr,0,len);
        Arrays.sort(tmpArr);
        int result = 0;
        for(int i=0;i<len;i++){
            int x = arr[i];
            int y = tmpArr[i];
            map.put(x,map.getOrDefault(x,0) + 1);
            if (map.get(x) == 0){
                map.remove(x);
            }
            map.put(y,map.getOrDefault(y,0) - 1);
            if (map.get(y) == 0){
                map.remove(y);
            }
            if(map.isEmpty()){
                result++;
            }
        }
        return result;
    }



    public static int maxChunksToSorted2(int[] arr) {
        int len = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            int tmp = arr[i];
            if(stack.isEmpty() || tmp >= stack.peek()){
                stack.push(tmp);
            }else {
                int tmpValue = stack.poll();
                while (!stack.isEmpty() &&  stack.peek() > tmp) {
                    stack.pop();
                }
                stack.push(tmpValue);
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));
        System.out.println(maxChunksToSorted2(arr));
    }
}

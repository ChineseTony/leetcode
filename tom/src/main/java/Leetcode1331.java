import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/7/28
 */
public class Leetcode1331 {

    public static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] tmpArr = new int[len];
        System.arraycopy(arr,0,tmpArr, 0, len);
        Arrays.sort(tmpArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:tmpArr) {
            if (!map.containsKey(i)){
                map.put(i,map.size()+1);
            }
        }
        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{40,10,20,30};
        int[] ints = arrayRankTransform(arr);
        System.out.println(Arrays.toString(ints));

    }
}

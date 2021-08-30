import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/30
 */
public class MergeArr {


    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return intervals;
        }
        int len = intervals.length;
        List<int[]> tmp = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            tmp.add(intervals[i]);
        }
        tmp.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < len){
            int left = tmp.get(i)[0];
            int right = tmp.get(i)[1];
            while (i < len -1 && tmp.get(i+1)[0] <= right){
                right = Math.max(right,tmp.get(i+1)[1]);
                i++;
            }
            i++;
            result.add(new int[]{left,right});
        }
        return result.toArray(new int[0][0]);
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }


    }
}

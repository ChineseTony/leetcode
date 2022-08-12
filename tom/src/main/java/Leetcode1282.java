import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/8/12
 */
public class Leetcode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0;i<groupSizes.length;i++){
            int value = groupSizes[i];
            if(value == 1){
                List<Integer>  tmp = new ArrayList<>();
                tmp.add(i);
                result.add(tmp);
                continue;
            }
            if (!map.containsKey(value)){
                List<Integer>  tmp = new ArrayList<>();
                tmp.add(i);
                map.put(value, tmp);
            }else{
                List<Integer> integers = map.get(value);
                integers.add(i);
                if (integers.size() == value){
                    result.add(new ArrayList<>(integers));
                    integers.clear();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] groupSizes = new int[]{2,1,3,3,3,2};
        Leetcode1282 leetcode1282 = new Leetcode1282();
        List<List<Integer>> lists = leetcode1282.groupThePeople(groupSizes);
        for(List<Integer> tmp:lists){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }
    }
}

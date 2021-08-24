import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/24
 */
public class CombinationSum2 {


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<Integer> tmp = new ArrayList<>(len);
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visit=new boolean[candidates.length];
        dfs(candidates,target,0,result,tmp,visit);
        return result;
    }

    private static void dfs(int[] candidates,int target,
                     int index,List<List<Integer>> result,
                     List<Integer> tmp,boolean[] visit){
        if (target == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            if (visit[i]) {
                return;
            }
            // 去重
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            tmp.add(candidates[i]);
            visit[i] = true;
            dfs(candidates,target-candidates[i], i+1,result,tmp,visit);
            tmp.remove(tmp.size()-1);
            visit[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> tmp:lists){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }
    }
}

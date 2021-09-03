import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangtao
 * @date 2021/9/2
 */
public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        dfs(tmp,result,k,1,n,0,sets);
        return result;
    }

    private static void dfs(List<Integer> tmp,List<List<Integer>> result,
                            int k,int index,int n,int sum,Set<String> sets){
        if (k == 0 && sum == n){
            Integer[] integers = tmp.toArray(new Integer[0]);
            Arrays.sort(integers);
            String s = Arrays.toString(integers);
            if (!sets.contains(s)) {
                sets.add(s);
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (sum > n){
            return;
        }
        for (int i = index; i < 10; i++) {
            if (tmp.contains(i)){
                continue;
            }
            tmp.add(i);
            dfs(tmp,result,k-1,index+1,n,sum+i,sets);
            tmp.remove(tmp.size()-1);
        }
    }


    public static void main(String[] args) {
        int k = 5;
        int n = 18;
        List<List<Integer>> lists = combinationSum3(k, n);
        for (List<Integer> tmp:lists){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }


    }
}

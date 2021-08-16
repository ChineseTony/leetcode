import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/16
 */
public class CountArrangement {

    public int countArrangement(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(1,n,result,tmp);
        System.out.println(result.size());
        for (List<Integer> integers:result){
            System.out.println(Arrays.toString(
                    integers.toArray(new Integer[0])
            ));
        }
        return result.size();
    }


    private void dfs(int tmpIndex, int length,
                     List<List<Integer>> result,List<Integer> tmp){
        if (tmp.size() == length){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 1; i <= length; i++) {
            if (tmp.contains(i)){
                continue;
            }
            if ( tmpIndex % i != 0 &&  i % tmpIndex != 0 ){
                continue;
            }
            tmp.add(i);
            dfs(tmpIndex+1,length,result,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        CountArrangement countArrangement = new CountArrangement();
        countArrangement.countArrangement(6);
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/9/7
 */
public class PartitionHuiWen {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0){
            return result;
        }
        List<String> tmp = new ArrayList<>();
        dfs(result,tmp,0,s);
        return result;

    }

    private void dfs(List<List<String>> result,List<String> tmp,int i,String s){
        if (i == s.length()){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j < s.length() ; j++) {
            if (isHuiWen(s.substring(i,j+1))){
                tmp.add(s.substring(i,j+1));
                dfs(result,tmp,j+1,s);
                tmp.remove(tmp.size()-1);
            }

        }
    }

    private boolean isHuiWen(String s){
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length()-1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionHuiWen partitionHuiWen = new PartitionHuiWen();
        String s = "aab";
        List<List<String>> partition = partitionHuiWen.partition(s);
        for (List<String> tmp:partition){
            System.out.println(Arrays.toString(tmp.toArray(new String[0])));
        }
    }
}

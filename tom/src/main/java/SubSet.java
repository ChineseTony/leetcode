import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/8
 */
public class SubSet {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() <= 0) {
            return result;
        }
        char[] tmpArray = s.toCharArray();
        List<String> tmpList = new ArrayList<>();
        dfs(tmpArray,0,result,tmpList);
        return result;
    }

    private static void dfs(char[] arr,int index,List<List<String>>
            result,List<String> tmp){
        if (index == arr.length){
            result.add(new ArrayList<>(tmp));
            return;
        }
        dfs(arr,index+1,result,tmp);
        tmp.add(String.valueOf(arr[index]));
        dfs(arr,index+1,result,tmp);
        tmp.remove(tmp.size()-1);

    }

    public static void main(String[] args) {
        String s = "abc";
        List<List<String>> partition = partition(s);
        for (List<String> list:partition){
            System.out.println(Arrays.toString(list.toArray(new String[0])));
        }
    }
}

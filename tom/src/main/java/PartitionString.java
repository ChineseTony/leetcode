import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/8
 */
public class PartitionString {

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
        for(int i = index; i < arr.length; i++){
            if(isPalindrome(arr,index, i)){
                tmp.add(new String(arr, index, i + 1 - index));
                dfs(arr,i + 1,result,tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    private static boolean isPalindrome(char[] arr,int left,int right){
        while (left >= 0 && right < arr.length && left < right){
            if (arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        //1.求字符串所有子集 判断字符串是不是回文字符串
        String s = "aab";
        List<List<String>> partition = partition(s);
        for (List<String> list:partition){
            System.out.println(Arrays.toString(list.toArray(new String[0])));
        }


    }

}

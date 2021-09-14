import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/9/14
 */
public class FindLongestWord {

    public static String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String tmp:dictionary){
            int i = 0;
            int j=0;
            while (i < s.length() && j < tmp.length()){
                if (s.charAt(i) == tmp.charAt(j)){
                    j++;
                }
                i++;
                if (j == tmp .length()){
                    boolean flag = tmp.length() > result.length() ||
                            (tmp.length() == result.length()
                                    && tmp.compareTo(result) < 0);
                    if (flag){
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> arr = new ArrayList<>(
                Arrays.asList("ale","apple","monkey","plea")
        );
        String longestWord = findLongestWord(s, arr);
        System.out.println(longestWord);


    }
}

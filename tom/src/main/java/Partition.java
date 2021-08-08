import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/8
 */
public class Partition {

    public static List<List<String>> partition(String s) {
        if (s == null || s.length() <= 0){
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }


    public static String reverseWords(String s) {
        if (s == null || s.length() <= 0){
            return s;
        }
        String tmp = s.trim();
        String[] arr = tmp.split("\\s+");
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len-1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "abbacdeeda";
        List<List<String>> partition = partition(s);
        for (List<String> tmp:partition){
            System.out.println(tmp.toArray(new String[0]));
        }
        System.out.println(reverseWords("a good   example"));
    }


}

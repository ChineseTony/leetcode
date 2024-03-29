import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/10/30
 */
public class Leetcode784 {

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        dfs(s.toCharArray(),0,result);
        return result;
    }

    private static void dfs(char[] chars,int index,List<String> result){
        while (index < chars.length && Character.isDigit(chars[index])){
            index++;
        }
        if (index == chars.length){
            result.add(new String(chars));
            return;
        }
        chars[index] = cateLetter(chars[index]);
        dfs(chars,index+1,result);
        chars[index] = cateLetter(chars[index]);
        dfs(chars,index+1,result);
    }


    public boolean all(String[] words1, String[] word2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String word : words1){
            sb1.append(word);
        }
        for (String word : word2){
            sb2.append(word);
        }
        return sb1.toString().equals(sb2.toString());
    }

    private static char cateLetter(char c){
        if (Character.isLowerCase(c)){
            return (char) (c - 32);
        }else {
            return (char) (c + 32);
        }
    }

    public static void main(String[] args) {
        String s = "12345";
        List<String> strings = letterCasePermutation(s);
        for (String str : strings) {
            System.out.println(str);
        }

    }
}

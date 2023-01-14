import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/10/23
 */
public class Leetcode1768 {

    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0){
            return word2;
        }
        if (word2 == null || word2.length() == 0){
            return word1;
        }
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int p = 0;
        int q = 0;
        while (p < len1 && q < len2){
            sb.append(word1.charAt(p));
            sb.append(word2.charAt(q));
            p++;
            q++;
        }
        if (p < len1){
            sb.append(word1.substring(p));
        }else {
            sb.append(word2.substring(q));
        }
        return sb.toString();

    }


    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        int index = 0;
        if ("color".equals(ruleKey)){
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        }else{
            index = 0;
        }
        for (List<String> item:items){
            if (ruleValue.equals(item.get(index))){
                result++;
            }
        }
        return result;
    }

    private static final String PUSH = "Push";

    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int index = 1;
        for (int j = 0; j < n; j++) {
            if (i >= target.length){
                break;
            }
            if (target[i] == index){
                result.add(PUSH);
                i++;
            }else {
                result.add(PUSH);
                result.add(POP);
            }
            index++;
        }
        return result;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        for(String word : words) {
            if (match(s,word)){
                result++;
            }
        }
        return result;
    }


    // abcdea ada
    // a 0 5  d 3
    // p = 3
    private boolean match(String s,String word) {
        int len1 = s.length();
        int len2 = word.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2){
            if (s.charAt(i) != word.charAt(j)){
                i++;
            }else {
                i++;
                j++;
            }
        }
        return j >= len2;
    }

    public int expressiveWords(String s, String[] words) {
        int result = 0;
        int[] chars = new int[26];
        for (char c:s.toCharArray()){
            chars[c - 'a'] ++;
        }
        for (String word:words){
            if (canExpress(word,chars)){
                result++;
            }
        }
        return result;
    }

    private boolean canExpress(String s,int[] chars){
        int[] tmpArr = new int[26];
        for (char c:s.toCharArray()){
            tmpArr[c - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (tmpArr[i] == 0 && chars[i] != 0){
                return false;
            }
            if (tmpArr[i] > chars[i]){
                return false;
            }
            if (chars[i] - tmpArr[i] == 0){
                continue;
            }
            if (chars[i] - tmpArr[i] <= 2){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Leetcode1768 leetcode = new Leetcode1768();
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(leetcode.mergeAlternately(word1,word2));
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        System.out.println(leetcode.numMatchingSubseq(s, words));
        words = new String[]{"hello", "hi", "helo"};
        s = "heeellooo";
        System.out.println(leetcode.expressiveWords(s,words));



    }
}

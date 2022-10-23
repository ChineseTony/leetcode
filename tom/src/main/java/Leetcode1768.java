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

    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(new Leetcode1768().mergeAlternately(word1,word2));

    }
}

/**
 * @author wangtao
 * @date 2022/8/16
 */
public class ShortestCompletingWord {


    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] tmp = new char[26];
        for (char c:licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                tmp[Character.toLowerCase(c) - 'a']++;
            }

        }

        int len = words.length;
        int k = -1;
        for (int j=0;j<len;j++){
            String word = words[j];
            char[] tmpArr = new char[26];
            for (char c:word.toCharArray()) {
                tmpArr[c- 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (tmpArr[i] < tmp[i]){
                    ok = false;
                    break;
                }
            }
            if(ok && (k < 0 || words[j].length() < words[k].length())){
                k = j;
            }
        }
        return k ==  -1 ? "" : words[k];
    }


    public static void main(String[] args) {
        String s ="1s3 PSt";
        String[] words = new String[]{"steps"};
        String result = new ShortestCompletingWord().shortestCompletingWord(s,words);
        System.out.println(result);


    }
}

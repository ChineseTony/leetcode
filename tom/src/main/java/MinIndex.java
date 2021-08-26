/**
 * @author wangtao
 * @date 2021/8/25
 */
public class MinIndex {

    /**
     *
     * @param words  [1,-1,3,1,0,2,2,1]
     * @param word1 1
     * @param word2 2
     * @return 1～2的最小值
     */
    public static int minIndex(String[] words,String word1,String word2){
        int[] indexes1 = new int[words.length];
        int[] indexes2 = new int[words.length];
        int m = 0, n = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                indexes1[m++] = i;
            } else if (word.equals(word2)) {
                indexes2[n++] = i;
            }
        }
        int dist = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < m && j < n; ) {
            int x = indexes1[i];
            int y = indexes2[j];
            dist = Math.min(dist, Math.abs(x - y));
            if (x < y) {
                i++;
            } else {
                j++;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}

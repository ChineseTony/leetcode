import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/7/11
 */
public class HIndex {

    public static int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0){
            return -1;
        }
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - i - 1]
        > i){
            i++;
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{100};
        System.out.println(hIndex(nums));

    }
}

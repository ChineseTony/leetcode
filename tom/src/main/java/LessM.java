

/**
 * @author wangtao
 * @date 2021/8/21
 */
public class LessM {

    //找出数组 2个数字和 小于m的数字
    public static int lessM(int[] arr,int m){
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int tmp = arr[i];
            for (int j = i+1; j < len; j++) {
                tmp += arr[j];
                if (tmp <= m){
                    count++;
                }
                tmp -= arr[j];
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

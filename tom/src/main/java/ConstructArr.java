/**
 * @author wangtao
 * @date 2021/8/3
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 0){
            return a;
        }
        int len = a.length;

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int tmp = 1;
            for (int j = 0; j < len; j++) {
                if (j != i){
                    tmp *= a[j];
                }
            }
            result[i] = tmp;
        }
        return result;
    }

    public int[] constructArr2(int[] a) {
        if (a == null || a.length <= 0){
            return a;
        }
        int len = a.length;

        int[] result = new int[len];
        result[0] = 1;
        int tmp = 1;
        //计算下三角
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        //计算上三角
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i+1];
            result[i] *= tmp;
        }
        return result;
    }


}

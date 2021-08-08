/**
 * @author wangtao
 * @date 2021/8/8
 */
public class Tribonacci {

    public static int tribonacci(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return tribonacci(n-3) + tribonacci(n-2)
                + tribonacci(n-1);
    }

    public static int tribonacci2(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int s = 1;
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 3; i <= n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
        System.out.println(tribonacci2(25));
    }


}

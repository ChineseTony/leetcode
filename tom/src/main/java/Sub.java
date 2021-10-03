/**
 * @author wangtao
 * @date 2021/9/28
 */
public class Sub {

    public static void main(String[] args) {

        int n = 10;
        int[] a = new int[n];
        int[][] f = new int[n][n];
        for(int i = 1; i <= n; i ++){
            if (f[i][1] % 2 == 0) {
                f[i][1] = 1;
            }
        }
        for(int len = 2; len <= n; len ++)
        {
            for(int i = 2; i <= n; i ++)
            {
                for(int j = 1; j < i; j ++)
                {
                    if(a[i] > a[j])
                    {
                        f[i][len] = (f[i][len] + f[j][len - 1]) % 1000007;
                    }
                }
            }
        }

        long  res = 0;
        for(int i = 1; i <= n; i ++) {
            res += f[i][i];
        }


    }
}

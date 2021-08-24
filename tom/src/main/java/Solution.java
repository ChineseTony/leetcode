

/**
 * @author wangtao
 * @date 2021/8/23
 */
public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nm int整型二维数组 可逆矩阵n*m
     * @return int整型
     */
    public static int minPathSum (int[][] nm) {
        int col = nm.length;
        int row = nm[0].length;
        int[][] tmp = new int[col][row];
        //1.第一行
        tmp[0][0] = nm[0][0];
        for (int i = 1; i < row; i++) {
            tmp[0][i] = tmp[0][i-1] + nm[0][i];
        }
        //2.第一列
        for (int i = 1; i < col; i++) {
            tmp[i][0] =tmp[i-1][0] +  nm[i][0];
        }
        //3.动态规划更新下标
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                tmp[i][j] = nm[i][j] + Math.min(tmp[i][j-1],tmp[i-1][j]);
            }

        }
        return tmp[col-1][row-1];

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {3,1,0,2},{4,3,2,1},{5,2,1,0},{1,2,3,4},{0,0,0,1}
        };
        System.out.println(minPathSum(nums));
    }
}

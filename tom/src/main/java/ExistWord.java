/**
 * @author wangtao
 * @date 2021/9/2
 */
public class ExistWord {

    public static boolean exist(char[][] board, String word) {
        int i = board.length;
        int j = board[0].length;
        boolean[][] visited = new boolean[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                boolean flag = exists(board,visited,k,l,0,word);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exists(char[][] board,boolean[][] visited,
                           int i,int j,int k,String word){
        if (board[i][j] != word.charAt(k)){
            return false;
        }else if (k == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[][] direct = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        boolean result = false;
        for (int[] tmp:direct){
            int newI = i + tmp[0];
            int newJ = j + tmp[1];
            if (newI >= 0 && newI < board.length
            && newJ >= 0 && newJ < board[0].length){
                if (!visited[newI][newJ]){
                    boolean flag  = exists(board,visited,newI,newJ,k+1,word);
                    if (flag){
                       result = true;
                       break;
                    }
                }

            }
        }
        visited[i][j]=false;
        return result;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "SEE";
        System.out.println(exist(chars,word));

    }
}

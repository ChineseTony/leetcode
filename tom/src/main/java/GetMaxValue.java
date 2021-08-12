/**
 * @author wangtao
 * @date 2021/8/10
 */
public class GetMaxValue {

    public int getMax(int[] nums,int[] values){
        if (nums == null || nums.length == 0){
            return 0;
        }
        return dfs(0,nums.length-1,1,nums,values);
    }

    private int dfs(int i,int j,int count,int[] nums,int[] values){
        if (i == j){
            return nums[i] * values[count];
        }else {
            int tmpHead = nums[i] * values[count] +
                    dfs(i+1,j,count+1,nums,values);
            int tmpTail = nums[j] * values[count] +
                    dfs(i,j-1,count+1,nums,values);
            return Math.max(tmpHead,tmpTail);
        }

    }
}

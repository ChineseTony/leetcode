import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/4/20
 */
public class FindTargetSum {


    public static List<List<Integer>> findTargetSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),0,target,result);
        return result;
    }

    private static void dfs(int[] nums,int i,List<Integer> tmp,int sum,int target,List<List<Integer>> result){
        if (sum > target){
            return;
        }
        if (target == sum){
            result.add(new ArrayList<>(tmp));
        }
        for (int j = i; j < nums.length; j++) {
            tmp.add(j);
            sum += nums[j];
            dfs(nums,j+1,tmp,sum,target,result);
            sum -= nums[j];
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15,3,4,9};
        int target = 7;
        List<List<Integer>> targetSum = findTargetSum(nums, target);
        for(List<Integer> tmp:targetSum){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }

    }
}

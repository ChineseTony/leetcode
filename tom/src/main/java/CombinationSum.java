import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/5
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates,target,result,tmp,0);
        return result;
    }

    private static void combine(int[] candidates,int target,
                         List<List<Integer>> result,
                         List<Integer> tmpList,int i){
        int tmp = 0;
        for (Integer tmpVal:tmpList){
            tmp += tmpVal;
        }
        // 值为target跳出循环
        if (tmp == target){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        //超过 tmp大小跳出循环
        if (tmp > target){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            tmpList.add(candidates[j]);
            combine(candidates,target,result, tmpList,j);
            tmpList.remove(tmpList.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }

    public void find(List<List<Integer>> listAll,
                     List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]){
            return;
        }
        for(int i=num; i<candidates.length&&candidates[i]<=target;i++){
            //拷贝一份，不影响下次递归
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>>
                result = combinationSum(candidates,target);
        for (List<Integer> tmp:result){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }

    }

}

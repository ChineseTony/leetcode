/**
 * @author wangtao
 * @date 2021/8/10
 */
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] arr) {
        if (arr ==null || arr.length < 2){
            return 0;
        }
        int i = 2;
        int count = 0;
        int sum = 0;
        for (int j = 2; j < arr.length; j++) {
            if (arr[j] - arr[j-1] == arr[j-1] - arr[j-2]){
                count++;
            }else {
                sum += count * (count+1) / 2;
                count = 0;
            }
        }
        return sum + count * (count+1) / 2;
    }
}

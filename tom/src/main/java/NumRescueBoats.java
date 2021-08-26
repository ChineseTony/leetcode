import java.util.Arrays;

/**
 * @author wangtao
 * @date 2021/8/26
 */
public class NumRescueBoats {

    public static int  numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int result = 0;
        while (left <= right){
            if (people[left] + people[right] <= limit){
                left ++;
            }
            result++;
            right--;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,3,4};
        int limit = 3;
        System.out.println(numRescueBoats(nums,limit));
    }
}

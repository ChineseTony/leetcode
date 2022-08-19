/**
 * @author wangtao
 * @date 2022/8/19
 */
public class Leetcode1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if(queryTime >= start && queryTime <= end){
                result ++;
            }
        }
        return result;
    }
}

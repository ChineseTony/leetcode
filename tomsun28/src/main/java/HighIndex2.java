/**
 * @author tomsun28
 * @date 2021/7/12 0:11
 */
public class HighIndex2 {

    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}

/**
 * @author tomsun28
 * @date 2021/7/11 12:30
 */
public class HighIndex {

    public int hIndex(int[] citations) {
        for(int i = 0; i < citations.length - 1; i++) {
            for (int j = 0; j < citations.length - 1 - i; j++) {
                if (citations[j] > citations[j + 1]) {
                    int tmp = citations[j + 1];
                    citations[j + 1] = citations[j];
                    citations[j] = tmp;
                }
            }
        }

        for (int i = 0; i < citations.length; i ++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}

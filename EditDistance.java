import java.util.Collections;
import java.util.Arrays;

public class EditDistance {
    private int[][] arr;
    private String s1;
    private String s2;

    public EditDistance(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        arr = new int[s1.length()][s2.length()];
    }

    public int getDist() {
        //haven't calculated yet
        for (int i = 0; i < s1.length(); i++) {
            arr[i][0] = i;
        }

        for (int i = 0; i < s2.length(); i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < s1.length(); i++){
            for (int j = 1; j < s2.length(); j++) {
                arr[i][j] = Collections.min(Arrays.asList(arr[i-1][j] + 1, arr[i][j-1] + 1, arr[i-1][j-1] + diff(s1, s2, i, j)));
            }
        }
        return arr[s1.length() - 1][s2.length() - 1];
    }

    private static int diff(String s1, String s2, int index1, int index2) {
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 0;
        }
        return 1;
    }
}

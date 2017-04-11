package algorithm;

public class KMP {
    /**
     *
     * @param data
     * @param sub
     * @return
     */
    public int containSubStr(String data, String sub) {
        if (data == null || sub == null || data.length() < sub.length()) return -1;
        int i = 0, j = 0;
        int sLen = data.length();
        int pLen = sub.length();
        int[] next = getMatchLocation(sub);
        while (i < sLen && j < pLen) {
            if (j == -1 || data.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;

    }

    /**
     * KMP algorithm kernel module
     * @return
     */
    private int[] getMatchLocation(String sub) {

        int len = sub.length();
        int[] matchLocation = new int[len];
        int k = -1;
        int j = 0;
        matchLocation[0] = -1; //
        while (j < len - 1) {
            if (k == -1 || matchLocation[j] == matchLocation[k]) {
                k++;
                j++;
                if (matchLocation[j] != matchLocation[k]) {
                    matchLocation[j] = k;
                } else {
                    matchLocation[j] = matchLocation[k];
                }
            } else {
                k = matchLocation[k];
            }
        }
        return matchLocation;
    }

    public static void main(String[] args) {
        String a = "aba";
        String b = "ba";//"ababbaaba";//

        KMP solution = new KMP();
        System.out.println(solution.containSubStr(a, b));

    }
}

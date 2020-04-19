package misc;

public class LongestCommonSubs {

    public static void main(String[] args) {
        String str = "ACGTACGTAC";
        System.out.println(numberOfSaveDNA(str, 10, 0));
        System.out.println(numberOfSaveDNA(str, 10, 3));
    }

    private static int numberOfSaveDNA(String str, int n, int k) {
        int aCharCount = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (str.charAt(j - 1) == 'A') {
                    aCharCount++;
                }
                if (aCharCount <= k) {
                    if (result < j - i) {
                        result = j - i;
                    }
                } else {
                    break;
                }
            }
            aCharCount = 0;
        }
        return result;
    }

}
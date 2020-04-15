package string;

public class MaxOccurence {

    public static void main(String[] args) {
        String s = "aaaassffggttssssssss";
        System.out.println(getMaxOccurent(s));


    }

    public static int getMaxOccurent(String s) {
        if (null == s) {
            throw new IllegalArgumentException("Argume is null");

        }
        if (s.isEmpty() || s.trim().length() < 1) {
            return 1;
        }

        final int ASCII_SIZE = 256;
        int temArr[] = new int[ASCII_SIZE];
        char t[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            temArr[s.toCharArray()[i]]++;
        }
        int max = -1;
        for (int i = 0; i < temArr.length; i++) {
            max = max < temArr[i] ? temArr[i] : max;
        }
        return max;

    }
}


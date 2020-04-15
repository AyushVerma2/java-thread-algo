package string;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {

        char aa='t';
        char bb='t';
        char ee ='t';
        int cc=aa^bb^ee^aa;
        System.out.println(Character.getNumericValue('o') + "   "+ cc);
       System.out.println(removeDuplicate("ayushayush"));
    }

    public static String removeDuplicate(String s) {
        if (null == s) {
            throw new IllegalArgumentException("Argume is null");

        }

        int index = 0;
        char res[] = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int j;

            for (j = 0; j < i; j++) {
                if (res[j] == s.toCharArray()[i]) {
                    break;
                }
            }

            if (i == j) {
                res[index++] = s.toCharArray()[i];
            }


        }
        return String.valueOf(Arrays.copyOf(res, index));
    }
}

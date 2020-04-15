package string;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "ayush";
        String m = "ayuhs";
        System.out.println(isAnagram(s, m));
        System.out.println(iAnagram(s, m));
    }

    public static boolean iAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }


    public static boolean isAnagram(String s, String m) {

        if (s.length() != m.length()) {
            return false;

        }
        boolean isfound = false;
        for (int i = 0; i < s.length(); i++) {
            isfound = false;
            for (int j = 0; j < m.length(); j++) {
                if (m.toCharArray()[j] != 0 &&
                        s.toCharArray()[i] == m.toCharArray()[j]) {
                    m.toCharArray()[j] = 0;
                    isfound = true;
                    break;

                }

            }
        }
        return isfound;
    }
}

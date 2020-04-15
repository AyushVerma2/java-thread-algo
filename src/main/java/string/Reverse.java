package string;

public class Reverse {

    public static String reverse(String s) {

        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {

            res = res + s.toCharArray()[i];

        }
        return res;
    }

    public static String reverseRecurssion(String s) {

        if(s.length()<=1){
            return s;
        }
        return s.toCharArray()[s.length()-1]+reverseRecurssion(s.substring(0,
                s.length()-1));
    }

    public static void main(String[] args) {

        System.out.println(reverse("thisss"));
        System.out.println(reverseRecurssion("thisss"));
    }
}

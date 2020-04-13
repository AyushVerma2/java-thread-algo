package companyquestion.vmware.GEHealthCAre;

public class RandomAlphabat {

    static String createRandomeAphabet(int num){

        char []  alphabet =
                {'a','b','c','d','e','f','g','h'
                        ,'i','j','k','l','m','n'
                        ,'o','p','q','r','s'
                        ,'t','u','v','w','x','y'
                        ,'z'};

        String result="";

        for(int i=0;i<num;i++){
            result+=alphabet[(int)(Math.random() *10  % 26)];
        }
        return result;
    }

    public static void main(String a[]){
        System.out.println(createRandomeAphabet(10));
    }
}

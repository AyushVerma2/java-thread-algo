package string;

public class TwoStringrotation {
    public static void main(String[] args) {

       System.out.println(isRotation("ABCD","DABC"));
       System.out.println(isRotation("IndiaVsAustralia","AustraliaVsIndia"));
       System.out.println(isRotation("IndiaVsEngland","EnglandIndiaVs"));

    }

    public static boolean isRotation(String s,String e){
        if(s.length() != e.length()){
            return  false;
        }
        String t=s+s;
        if(t.indexOf(e)!= -1){
            return true;
        }
        return false;
    }
}

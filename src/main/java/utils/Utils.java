package utils;

public class Utils {

    public String concatenateWords(String a, String b){
        if (a == null && b==null){
            return null;
        }
        if (a == null){
            return b;
        }else if (b == null){
            return a;
        }
            return a + b;
    }


    public long computeFactorial(long n){
        return n == 1 ? 1 : n * computeFactorial( n-1 );
    }
}


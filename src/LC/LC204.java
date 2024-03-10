package LC;

public class LC204 {
    public static void main(String[] args) {
        countPrimes(10);
    }
    public static int countPrimes(int n) {
        int count=0;
        for (int i = 1; i <n ; i++) {
          if(isPrime(i)) count++;

        }
        return count;
    }


    public static boolean isPrime(int i){
        if(i==1) return false;
        for (int j = 2; j*j <=i ; j++) {
            if(i%j==0) return false;
        }
        return true;




    }
}

package LC;

import java.util.Arrays;

public class LC204TWO {
    public int countPrimes(int n) {
     boolean[] prime=new boolean[n];
        Arrays.fill(prime,true);
        int count=0;
        for (int i = 2; i <n ; i++) {
            if(prime[i]){
                count++;
                if((long)i*i<n){
                    for (int j = i*i; j <n ; j+=i) {
                        prime[j]=false;
                    }
                }

        }
    }
        return count;

}
}

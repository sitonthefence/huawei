package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW31TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> result=new ArrayList<>();
        for (int k = 1; k*k<2*n ; k++) {
            if(2*n%k!=0||(2*n/k-k+1)%2!=0) continue;
            int a=(2*n/k-k+1)/2;
            int b=a+k-1;

            result.add(new int[]{a,b});

        }
          result.forEach(System.out::println);

    }
    
    
}

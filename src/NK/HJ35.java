package NK;

import java.util.Scanner;

public class HJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int arr [][]=new int[source][source];
            int temp=0;
            for (int i=0;i<source;i++){
                for(int j=i,k=0;j>=0&&k<=i;j--,k++){
                    arr[j][k]=++temp;
                }
            }
            for (int i = 0; i < source; i++) {
                for (int j = 0; j <=source-i-1; j++) {
                    System.out.print(arr[i][j]+" ");

                }

                System.out.println();


            }






        }


    }
}

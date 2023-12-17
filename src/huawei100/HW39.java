package huawei100;

import java.util.*;

public class HW39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int[][] arr = new int[3][4];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                   arr[i][j]=in.nextInt();
                }
            }
            List<Integer> XList=new ArrayList<>();
            for (int i = 0; i < 3; i++) {
           XList.add(arr[i][0]);
                XList.add(arr[i][0]+arr[i][2]);
            }
            Collections.sort(XList);
            List<Integer>  YList=new ArrayList<>();
            for (int i = 0; i < 3; i++) {

                YList.add((arr[i][1]));
                YList.add((arr[i][1]-arr[i][3]));
            }
            Collections.sort(YList);
            int MidX1=XList.get(2);
            int MidX2=XList.get(3);
            int MidY1=YList.get(2);
            int MidY2=YList.get(3);
            if(MidX1>=arr[0][0]&&MidX1>=arr[1][0]&&MidX1>=arr[2][0]
                    &&MidX2<=arr[0][2]+arr[0][0]&&MidX2<=arr[1][2]+arr[1][0]&&MidX2<=arr[2][2]+arr[2][0]
                    &&MidY1>=arr[0][1]-arr[0][3]&&MidY1>=arr[1][1]-arr[1][3]&&MidY1>=arr[2][1]-arr[2][3]
                    &&MidY2<=arr[0][1]&&MidY2<=arr[1][1]&&MidY2<=arr[2][1]
            ){
                System.out.println((MidX2-MidX1)*(MidY2-MidY1));

            }else {

                System.out.println(0);
            }
        }
    }

}

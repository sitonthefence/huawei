package huaweiAB200;

import java.util.Scanner;

public class HW9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            String target = in.next();
            char[][] g=new char[m][n];
            for (int i = 0; i < m; i++) {
                String temp=in.next();
                for (int j = 0; j < n; j++) {
                    g[i][j]=temp.charAt(j);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(find(target,0,g,i,j)){
                        System.out.println((i+1)+" "+(j+1));
                        return;
                    }

                }

            }
            System.out.println("NO");

        }
    }
    public static boolean find(String target,int index, char[][] g,int x,int y){
        if(x<0||y<0||x>=g.length||y>= g[0].length){
            return false;
        }
        if(index==target.length()-1&&target.charAt(index)==g[x][y]){
            return true;
        }
        if(target.charAt(index)==g[x][y]){
            return find(target,index+1,g,x+1,y)
                    ||find(target,index+1,g,x-1,y)
                    ||find(target,index+1,g,x,y+1)
                   ||find(target,index+1,g,x,y-1);
        }
        return false;


    }

}

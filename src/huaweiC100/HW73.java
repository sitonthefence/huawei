package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW73 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();
            String[] split = line.split(" ");
            int m=Integer.valueOf(split[0]);
            int n=Integer.valueOf(split[1]);
            List<List<Integer>> list=new ArrayList<>();
            for (int i = 1; i < split.length/2; i++) {
                List<Integer> path=new ArrayList<>();
                   path.add(Integer.valueOf(split[2*i]));
                   path.add(Integer.valueOf(split[2*i+1]));
                list.add(path);
            }
            int[][] g=new int[m][n];
            int x=0;
            int y=0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).get(1); j++) {
                    g[x][y]=list.get(i).get(0);
                    if(y+1==n){
                        y=0;
                        x++;
                    }else {
                        y++;
                    }
                }
            }
            System.out.println(g[in.nextInt()][in.nextInt()]);
           in.nextLine();

        }
    }
}

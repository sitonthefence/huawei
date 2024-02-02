package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW1TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int[][] g=new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <column ; j++) {
                g[i][j]=in.nextInt();
            }
        }

        UnionFindSet set=new UnionFindSet(row*column);
        List<Integer> huawei=new ArrayList<>();
        List<Integer> destination=new ArrayList<>();
        int[][] route={{1,0},{-1,0},{0,-1},{0,1}};
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                int position=i*g[0].length+j;
                if(g[i][j]==2){
                    huawei.add(position);
                }
                if(g[i][j]==3){
                    destination.add(position);
                }
                if(g[i][j]!=1){
                    for (int k = 0; k < 4; k++) {
                        int x=i+route[k][0];
                        int y=j+route[k][1];
                        if(x>=0&&x<g.length&&y>=0&&y<g[0].length&&g[x][y]!=1) {
                            set.merge(position, x * g[0].length + y);
                        }
                    }

                }

            }
        }
        if(!set.isSame(huawei.get(0), huawei.get(1))){
            System.out.println(0);
            return;
        }
        int count =0;
        for (Integer des : destination) {
            if(set.isSame(huawei.get(0),des)) count++;
        }
        System.out.println(count);




    }

    static class UnionFindSet{
        int[] fa;

        public UnionFindSet(int n) {
            fa=new int[n];
            for (int i = 0; i < n; i++) fa[i]=i;
        }
        public int find(int x){
            if(fa[x]==x){
                return x;
            }
           return    fa[x]=find(fa[x]);
        }

        public void merge(int i,int j){
            fa[find(i)]=find(j);
        }

        public boolean isSame(int i,int j){
            return find(i)==find(j);
        }

    }
}

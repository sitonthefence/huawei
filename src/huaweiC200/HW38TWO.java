package huaweiC200;

import java.util.Scanner;

public class HW38TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] split = in.next().split(",");
        UnionFindSet unionFindSet = new UnionFindSet(num);
        for (int i = 0; i < split.length-1; i++) {
            unionFindSet.merge(Integer.valueOf(split[i]),Integer.valueOf(split[i+1]));
        }
        int[][] g=new int[num][num];
        for (int i = 0; i <num ; i++) {
            String[] col = in.next().split(",");
            for (int j = 0; j <num ; j++) {
                if(col[j].equals("1")){
                    unionFindSet.merge(i,j);
                }
            }
        }
        int count =0;
        for (int i = 0; i <num ; i++) {
            if(unionFindSet.isSame(i,Integer.valueOf(split[0]))){
                count++;
            }

        }
        System.out.println(count- split.length);

    }
    static class UnionFindSet{
        int fa[];

        public UnionFindSet(int n) {
         fa=new int[n];
         for (int i = 0; i < n; i++)  fa[i]=i;
        }
        public int find(int x){
            if(fa[x]==x){
                return x;
            }
            return  fa[x]=find(fa[x]);

        }
        public void merge(int i,int j){
            fa[find(i)]=find(j);
        }
        
        public boolean isSame(int i,int j){
            return find(i)==find(j);
        }
    }
}

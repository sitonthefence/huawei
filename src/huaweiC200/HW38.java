package huaweiC200;

import java.util.Scanner;


public class HW38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int sum=in.nextInt();
            UnionSearchSet unionSearchSet = new UnionSearchSet(sum);
            String infectPerson = in.next();
            String[] split = infectPerson.split(",");
            for (int i = 0; i < split.length-1; i++) {
                unionSearchSet.merge(Integer.valueOf(split[i]),Integer.valueOf(split[i+1]));
            }
            int[][] g=new int[sum][sum];
            for (int i = 0; i < sum; i++) {
                String[] split1 = in.next().split(",");
                for (int j = i+1; j < sum; j++) {
                   g[i][j]=Integer.valueOf(split1[j]);
                   if(g[i][j]==1){
                       unionSearchSet.merge(i,j);
                   }
                }
            }
            int count=0;
            for (int i = 0; i < sum; i++) {
                if(unionSearchSet.isSame(Integer.valueOf(split[0]),i)){
                    count++;
                }
            }

            System.out.println(count-split.length);
        }
    }
}
class UnionSearchSet{
    int fa[];

    public UnionSearchSet(int n) {
      fa=new int[n];
        for (int i = 0; i < n; i++) {
            fa[i]=i;
        }

    }
    public int find (int x){
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

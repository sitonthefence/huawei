package huaweiC200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW9TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cityNumber = in.nextInt();
        int[][] edge=new int[cityNumber-1][2];
        for (int i = 0; i < edge.length; i++) {
            edge[i][0]= in.nextInt();
            edge[i][1]=in.nextInt();
        }
        int min=Integer.MAX_VALUE;
        List<Integer> result=new ArrayList<>();
        for (int i = 1; i <=cityNumber ; i++) {
            UnionFindSet set=new UnionFindSet(cityNumber+1);
            for (int j = 0; j < edge.length; j++) {
                 if(edge[j][0]==i||edge[j][1]==i) continue;
                 set.merge(edge[j][0],edge[j][1]);
            }
            int[] ancestor=new int[cityNumber+1];
            for (int j = 1; j <=cityNumber ; j++) {
                ancestor[set.find(j)]++;
            }
            int per=Integer.MIN_VALUE;
            for (int j = 1; j <=cityNumber ; j++) {
                per=Math.max(per,ancestor[j]);
            }
            if(per==min){
                result.add(i);
            }else if(per<min){
                min=per;
                result=new ArrayList<>();
                result.add(i);
            }

        }
        Collections.sort(result);
        result.forEach(t-> System.out.print(t+" "));
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
        public boolean iSame(int i,int j){
            return find(i)==find(j);
        }

    }

}

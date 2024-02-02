package huaweiC200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW15TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        UnionFindSet set=new UnionFindSet(N+1);
        int M = in.nextInt();
        List<Edge> list=new ArrayList<>();
        for (int i = 0; i <M ; i++) {
              int X=in.nextInt();
              int Y=in.nextInt();
              int Z=in.nextInt();
              int P=in.nextInt();
              list.add(new Edge(X,Y,P==0?Z:0));
        }
        int price=0;
        Collections.sort(list,(o1, o2) ->o1.cost- o2.cost );
         boolean flag=false;
        for (Edge edge : list) {
            if(!set.isSame(edge.from, edge.to)){
                set.merge(edge.from, edge.to);
                price+=edge.cost;
            }
            if(set.count==2){
                flag=true;
                break;

            }
        }
        if(!flag){
            System.out.println(-1);
        }else {
            System.out.println(price);
        }

    }

    static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class UnionFindSet{
        int[] fa;
        int count;

        public UnionFindSet(int n) {
            fa=new int[n];
            for (int i = 0; i < n; i++) fa[i]=i;
            count=n;
        }
        public int find(int x){
            if(fa[x]==x){
                return x;
            }
            return    fa[x]=find(fa[x]);
        }

        public void merge(int i,int j){
            fa[find(i)]=find(j);
            count--;
        }

        public boolean isSame(int i,int j){
            return find(i)==find(j);
        }

    }
}

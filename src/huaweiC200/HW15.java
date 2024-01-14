package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N = in.nextInt();
            int M=in.nextInt();
            List<Edge> list=new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int X=in.nextInt();
                int Y=in.nextInt();
                int Z=in.nextInt();
                int P=in.nextInt();
                list.add(new Edge(X,Y,P==0?Z:0));

            }
            list.sort((o1,o2)-> o1.weight- o2.weight);
            int cost=0;
            UnionFindSet5G unionFindSet5G = new UnionFindSet5G(N + 1);
            for (Edge edge : list) {
                if(!unionFindSet5G.isSame(edge.from, edge.to)){
                    unionFindSet5G.merge(edge.from, edge.to);
                    cost+=edge.weight;
                }
                   if(unionFindSet5G.count==2){
                       System.out.println(cost);
                       return;
                   }

            }
            System.out.println(-1);
        }
    }
}
class Edge {
    int from;
    int to;

    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
class UnionFindSet5G{
    int fa[];
    int count;

    public UnionFindSet5G(int n) {
        count=n;
        fa=new int[n];
        for (int i = 0; i < n; i++) {
            fa[i]=i;
        }
    }
    public int find(int x){
        if(fa[x]==x){
            return x;
        }
        return  fa[x]=find(fa[x]);
    }
    public void merge(int i,int j){
        fa[find(i)]=find(j);
        count--;
    }
    public boolean isSame(int i,int j){

       return find(i)==find(j);
    }

}


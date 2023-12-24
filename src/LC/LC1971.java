package LC;

public class LC1971 {
    int[] fa;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        fa=new int[n];
        init(n);
        for (int i = 0; i < edges.length; i++) {
            merge(edges[i][0],edges[i][1]);
        }
        return isSame(source,destination);

    }
    public void init(int n){
        for (int i =0; i <n ; i++) {
            fa[i]=i;
        }
    }
    public int find(int x){
        if(fa[x]==x){
            return x;
        }
        fa[x]=find(fa[x]);
        return fa[x];
    }

    public void merge(int x,int y){
        fa[find(x)]=find(y);
    }

    public boolean isSame(int x,int y){
        return find(x)==find(y);
    }


}

package LC;

public class LC684 {

    int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
       fa=new int[edges.length+1];
       init(edges.length);
        for (int i = 0; i <edges.length ; i++) {
            if(isSame(edges[i][0],edges[i][1])){
                return edges[i];
            }
            else {
                merge(edges[i][0],edges[i][1]);
            }

        }
        return null;


    }
    public void init(int n){
        for (int i =1; i <=n ; i++) {
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

package TEST;

public class TEST5 {
    static class UnionFindSet{
        int []fa;

        public UnionFindSet(int n) {
            fa=new int[n];
            for (int i = 0; i < n; i++) {
                fa[i]=i;
            }
        }
        public  int find(int x){
            if(x!=fa[x]){
                return fa[x];
            }
            return fa[x]=find(fa[x]);

        }
        public  void  merge(int i,int j){
            fa[find(i)]=find(j);
        }


    }
}

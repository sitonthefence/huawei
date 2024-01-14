package huaweiC200;
//1.遍历初始数据 for
//2.遍历每个城市 for
    //2.1 非本身数据加入并查集
    //2.2  加入祖宗数组
import java.util.*;

public class HW9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int [][] relation=new int[n-1][2];
            for (int i = 0; i < n-1; i++) {
                relation[i][0]=in.nextInt();
                relation[i][1]=in.nextInt();
            }
            List<Integer> ans=new ArrayList<>();
            int result=Integer.MAX_VALUE;
            //第一个答案错误的原因
            for (int i = 1; i <=n ; i++) {
                UnionFindSet unionFindSet = new UnionFindSet(n+1);
                int[] ancestor=new int[n+1];
                int MaxCount =Integer.MIN_VALUE;
                for (int j = 0; j <n-1 ; j++) {
                    int x=relation[j][0];
                    int y=relation[j][1];
                    if(x==i||y==i){
                        continue;}
                    unionFindSet.merge(x,y);
                }
                for (int j = 1; j <=n ; j++) {
                    ancestor[unionFindSet.find(j)]++;
                }
                Arrays.sort(ancestor);
                MaxCount=Math.max(MaxCount,ancestor[ancestor.length-1]);
                if(MaxCount<result){
                    ans=new ArrayList<>();
                    ans.add(i);
                    result=MaxCount;
                }else if(MaxCount==result){
                    ans.add(i);
                }
            }
            Collections.sort(ans);
            for (Integer an : ans) {
                System.out.print(an+" ");
            }
        }
    }
}
class UnionFindSet{
     int[] fa;
     public  UnionFindSet(int n) {
        fa=new int[n];
        for (int i = 0; i <n ; i++) {
            fa[i]=i;
        }
    }
    public  int find(int x){
        if(fa[x]==x){
            return x;
        }
        return  fa[x]=find(fa[x]);
    }
    public  void merge(int i,int j){
        fa[find(i)]=find(j);
    }


}

package huaweiC100;

import java.util.*;

public class HW75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        List<Pair> list=new ArrayList<>();
        while (in.hasNextInt()){
            int left = in.nextInt();
          int right=left+in.nextInt()-1;
          list.add(new Pair(left,right));
        }
        Collections.sort(list,(o1, o2)-> o1.right-o2.right);
        for (int i = 0; i < list.size(); i++) {
            int l=list.get(i).left;
            int r=list.get(i).right;
            if(l<0||l>99||r<0||r>99||l>r){
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            int right=list.get(i).right;
            int left=list.get(i+1).left;
            if(right>=left){
                System.out.println(-1);
                return;
            }
        }
        int position=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if(i==0){
                if(list.get(0).left>=target&&list.get(0).left<min){
                   position=0;
                   min=list.get(0).left;
                }
            }else {
                if(list.get(i).left-list.get(i-1).right-1>=target&&list.get(i).left-list.get(i-1).right-1<min){
                    position=list.get(i-1).right+1;
                    min=list.get(i).left-list.get(i-1).right-1;
                }
            }
        }
        if((99-list.get(list.size()-1).right)>=target&&(99-list.get(list.size()-1).right)<min){
            position=list.get(list.size()-1).right+1;
    //        min=99-list.get(list.size()-1).right;
        }
        if(position==-1){
            System.out.println(-1);
        }else {
            System.out.println(position);
        }
    }

}
class  Pair{
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

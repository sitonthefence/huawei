package huaweiC100;

import java.util.*;

public class HW75TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        List<Pair> list=new ArrayList<>();
        while (in.hasNextInt()){
            int left= in.nextInt();
            int right=left+ in.nextInt()-1;
            list.add(new Pair(left,right));
        }
        Collections.sort(list,(o1, o2)->o1.right- o2.right);
        if(!check(list)){
            System.out.println(-1);
            return;
        }
        int position=-1;
        int minMemory=Integer.MAX_VALUE;
        int currentMemory=0;
        for (int i = 0; i < list.size(); i++) {
            if(i==0){
                currentMemory=list.get(0).left;
                if(currentMemory>=target&&currentMemory<minMemory){
                    position=0;
                    minMemory=currentMemory;
                }

            }else {
                currentMemory=list.get(i).left-list.get(i-1).right-1;
                if(currentMemory>=target&&currentMemory<minMemory){
                    position=list.get(i-1).right+1;
                    minMemory=currentMemory;
                }

            }
        }
        currentMemory=99-list.get(list.size()-1).right;
        if(currentMemory>=target&&currentMemory<minMemory){
            position=list.get(list.size()-1).right+1;
        }
        System.out.println(position);
    }
    public static boolean check(List<Pair> list){
        for (int i = 0; i < list.size(); i++) {
            int l=list.get(i).left;
            int r=list.get(i).right;
            if(l<0||l>99||r<0||r>99||l>r){
                return false;
            }
            if(i!=0&&list.get(i-1).right>=list.get(i).left){
                return false;
            }
        }
        return true;
    }

    static class Pair{
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}

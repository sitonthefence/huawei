package NK;

import java.util.*;

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int length = in.nextInt();
            int k= in.nextInt();
            List<Pair> list=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(new Pair(in.next(),in.nextInt()));
            }
            if(k==0){
                Collections.sort(list,(a,b)->b.score-a.score);

            }else {
                Collections.sort(list,(a,b)->a.score-b.score);
            }
            for (Pair pair : list) {
                System.out.println(pair.name+" "+pair.score);
            }
        }
    }
    static class Pair{
        String name;
        Integer score;

        public Pair(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
    }


}

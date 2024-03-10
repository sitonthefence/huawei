package NC37;

public class NC28 {
    public static void main(String[] args) {
        System.out.println(minWindow("a", "b"));
    }

        public static  String minWindow (String S, String T) {
          if(T.length()>S.length()){
              return "";
          }

            // write code here
            int total=T.length();
            int left=0;
            int right=0;
            int[] count=new int[128];
            int min=Integer.MAX_VALUE;
            int a=-1;
            int b=-1;
            for (int i = 0; i < T.length(); i++) {
                count[T.charAt(i)]++;
            }
            while (right<S.length()){
                if(count[S.charAt(right)]>0){
                    total--;
                }
                count[S.charAt(right)]--;
                while (total==0){
                    if(right-left+1<min){
                        min=right-left+1;
                        a=left;
                        b=right+1;
                    }
                    if(count[S.charAt(left)]>=0){
                        total++;
                    }
                    count[S.charAt(left)]++;
                    left++;
                }
                right++;

            }
            if(min==Integer.MAX_VALUE) return "";

         return   S.substring(a,b);
        }

}

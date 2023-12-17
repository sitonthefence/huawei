package NK;

import java.util.*;

public class H27 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<String> list1=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list1.add(in.next());
            }
            String target=in.next();
            List<String> list2=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if(iSBrother(list1.get(i),target)){
                    list2.add(list1.get(i));
                }
            }
            Collections.sort(list2);
            System.out.println(list2.size());
            int i = in.nextInt();
            if(i>list2.size()){
                System.out.println(list2.get(i-1));

            }


        }


    }
    public static boolean iSBrother(String s1,String s2){
        if (s1.length()!= s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return false;
        }
        char[] char1= s1.toCharArray();
        char[] char2= s2.toCharArray();
       Arrays.sort(char1);
       Arrays.sort(char2);
        return new String(char1).equals(new String(char2));



    }


}

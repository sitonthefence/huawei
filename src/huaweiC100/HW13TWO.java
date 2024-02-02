package huaweiC100;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW13TWO {
    static ArrayDeque<Long> num_stack=new ArrayDeque<>();
    static ArrayDeque<Character> char_stack=new ArrayDeque<>();
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        //注意顺序
        Pattern p = Pattern.compile("\\d+([+*-]\\d+)*");
        Matcher matcher = p.matcher(source);
        long MaxLength=Long.MIN_VALUE;
        String str="";
        while (matcher.find()){
            String group = matcher.group();
            if(group.length()>MaxLength){
                str=group;
                MaxLength=group.length();
            }
        }
        if(str.length()==0){
            System.out.println(0);
            return;
        }
        int i=0;

        Map<Character,Integer> priority=new HashMap<>();
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);

        while (i<str.length()){
            char c=str.charAt(i);
            if(c>='0'&&c<='9'){
                StringBuilder numStr = new StringBuilder();
                while (c>='0'&&c<='9'){
                    numStr.append(c);
                    int j=i+1;
                    if(j==str.length()){
                        break;
                    }
                    i++;
                    c=str.charAt(i);
                }
                num_stack.offerLast(Long.valueOf(numStr.toString()));
            }
             if(c=='*'||c=='-'||c=='+'){
                 while (char_stack.size()>0&&priority.get(char_stack.peekLast())>=priority.get(c)){
                     cal();
                 }
                 char_stack.add(c);
             }



          i++;
        }
        while (num_stack.size()>1){
            cal();
        }
        System.out.println(num_stack.peekLast());



    }
   public static void cal(){
       Long b = num_stack.pollLast();
       Long a = num_stack.pollLast();
       Character c = char_stack.pollLast();
       long result=0;
       if(c=='+'){
           result=a+b;
       } else if (c=='-') {
           result=a-b;
       }else {
           result=a*b;
       }
       num_stack.offerLast(result);


   }

}

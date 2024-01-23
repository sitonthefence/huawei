package huaweiC200;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW47 {
    static  class Fraction{
        int fa;
        int ch;
        public Fraction() {
        }

        public Fraction(int fa, int ch) {
            this.fa = fa;
            this.ch = ch;
        }
    }
   static ArrayDeque<Fraction> num_stack=new ArrayDeque<>();
   static ArrayDeque<Character> char_stack=new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){

            Map<Character,Integer> priority=new HashMap<>();
            priority.put('+',1);
            priority.put('-',1);
            priority.put('*',2);
            priority.put('/',2);
            String source = in.nextLine();
            int i=0;
            while (i<source.length()){
                char c=source.charAt(i);
                if(c>='0'&&c<='9'){
                    StringBuilder stringBuilder=new StringBuilder();
                    while (c>='0'&&c<='9'){
                        stringBuilder.append(c);
                        if(i==source.length()-1){
                         break;
                        }
                        i++;
                        //不能丢
                        c=source.charAt(i);
                    }
                    num_stack.offerLast(new Fraction(1,Integer.parseInt(stringBuilder.toString())));
                }
                if(c=='+'||c=='-'||c=='*'||c=='/'){
                    //注意char_stack.size()>0
                    while(char_stack.size()>0&&char_stack.peekLast()!='('&&priority.get(char_stack.peekLast())>=priority.get(c)){
                      cal();
                    }
                    char_stack.offerLast(c);
                }else if(c==')'){
                    while (char_stack.peekLast()!='('){
                        cal();
                    }
                    char_stack.pollLast();

                }else if(c=='('){
                    char_stack.offerLast(c);
                }
                i++;
            }
            while (num_stack.size()>1){
                cal();
            }
            Fraction result = num_stack.peekLast();
            String str=new String();
            if(result.fa==0){
                System.out.println("ERROR");
                return;
            }
//防止溢出
           if((long)result.fa*(long) result.ch<0){
               str="-";
           }
            int k = maxCommonDivisor(result.ch, result.fa);
            result.ch/=k;
            result.fa/=k;
            int ch=Math.abs(result.ch);
            int fa=Math.abs(result.fa);
           StringBuilder stringBuilder=new StringBuilder();
           //所有值必须绝对值
           if(fa==1){
               stringBuilder.append(str).append(ch);
           }else {
               stringBuilder.append(str).append(ch).append("/").append(fa);
           }
            System.out.println(stringBuilder);
        }
    }
    public static void cal(){
        Fraction b = num_stack.pollLast();
        Fraction a = num_stack.pollLast();
        Character character = char_stack.pollLast();
        Fraction tmp=new Fraction();
        if(character=='+'){
             tmp.fa=a.fa*b.fa;
             tmp.ch=a.ch*b.fa+a.fa*b.ch;
        }else if(character=='-'){
           tmp.fa=a.fa*b.fa;
            tmp.ch=a.ch*b.fa-a.fa*b.ch;
        }else if(character=='*'){
           tmp.fa=a.fa*b.fa;
           tmp.ch=a.ch*b.ch;

        }else if(character=='/'){
              tmp.fa=a.fa*b.ch;
              tmp.ch=a.ch*b.fa;
        }
        num_stack.add(tmp);


    }
    public static int maxCommonDivisor(int x,int y){
        while (y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;

    }
}

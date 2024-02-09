package huaweiC200;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW47TWO {
    static ArrayDeque<Fraction> numStack;
   static ArrayDeque<Character> charStack;
    public static void main(String[] args) {
        numStack = new ArrayDeque<>();
       charStack=new ArrayDeque<>();
        Map<Character,Integer> priority=new HashMap<>();
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        Scanner in = new Scanner(System.in);
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
                    c=source.charAt(i);
                }
                numStack.offerLast(new Fraction(Integer.parseInt(stringBuilder.toString()),1));
            }
            if(c=='+'||c=='-'||c=='*'||c=='/'){
                while (!charStack.isEmpty()&&charStack.peekLast()!='('&&priority.get(charStack.peekLast())>=priority.get(c)){
                    cal();
                }
                charStack.offerLast(c);
            }else if(c==')'){
                while (charStack.peekLast()!='('){
                    cal();
                }
                charStack.pollLast();

            }else if(c=='('){
                charStack.offerLast('(');
            }
        i++;
        }
        while (numStack.size()>1){
            cal();
        }
        Fraction result = numStack.pollLast();
        if(result.mother==0){
            System.out.println("ERROR");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if((long)result.mother*(long)result.son<0){
            stringBuilder.append("-");
        }
        int maxYueShu = getMaxYueShu(result.mother, result.son);

        result.mother= Math.abs(result.mother/maxYueShu);
        result.son=Math.abs(result.son/maxYueShu);
        if(result.mother==1){
          stringBuilder.append(result.son);
        }else {
            stringBuilder.append(result.son).append("/").append(result.mother);
        }
        System.out.println(stringBuilder);

    }
    static void cal(){
        Fraction b = numStack.pollLast();
        Fraction a = numStack.pollLast();
        Character character = charStack.pollLast();
        Fraction result = new Fraction();
        if(character=='+'){
            result.son= a.son*b.mother+b.son*a.mother;
            result.mother=a.mother*b.mother;
        }else if(character=='-') {
            result.son= a.son*b.mother-b.son*a.mother;
            result.mother=a.mother*b.mother;
        }else if(character=='*'){
            result.son=a.son*b.son;
            result.mother=a.mother*b.mother;

        }else {
            result.son=a.son*b.mother;
            result.mother=a.mother*b.son;
        }
        numStack.offerLast(result);
    }
    static int getMaxYueShu(int x,int y){
        while (y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
    static class Fraction{
        int son;
        int mother;

        public Fraction() {
        }

        public Fraction(int son, int mother) {
            this.son = son;
            this.mother = mother;
        }
    }

}
